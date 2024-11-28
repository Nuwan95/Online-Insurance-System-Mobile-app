package com.example.nuwanwanigasingha.onlineinsurence;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.provider.SyncStateContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

//import net.gotev.uploadservice.MultipartUploadRequest;
//import net.gotev.uploadservice.UploadNotificationConfig;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.bitmap;

public class photo extends AppCompatActivity implements View.OnClickListener {
    //private static final  String SERVER_ADDRESS =""


    private APIService mAPIService;
    private static final int RESULT_LOAD_IMAGE = 1;
    private Uri filePath;
    private Bitmap bitmap;
    ImageButton camera_btn;
    ImageButton file_btn;
    ImageView imageview1,imageview2;
    Button upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        camera_btn = (ImageButton) findViewById(R.id.imageButton);
        file_btn = (ImageButton) findViewById(R.id.file_btn);
        imageview1 = (ImageView) findViewById(R.id.imageView4);
        imageview2 = (ImageView) findViewById(R.id.imageView5);
        upload_btn = (Button) findViewById(R.id.upload_btn);

        camera_btn.setOnClickListener(this);
        file_btn.setOnClickListener(this);
        upload_btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
                break;
            case R.id.file_btn:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,RESULT_LOAD_IMAGE);
                break;
            case R.id.upload_btn:
                uploadImage();
                //Bitmap image = ((BitmapDrawable)imageview1.getDrawable()).getBitmap();
                //uploadMultipart();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageview1.setImageBitmap(bitmap);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectedImage = data.getData();
            imageview2.setImageURI(selectedImage);
        }
    }

    private String imageToString(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte,Base64.DEFAULT);
    }

    private void uploadImage(){
        final String Image = imageToString();
        mAPIService = ApiUtils.getAPIService();
        Call<image> call = mAPIService.uploadimage(Image);
        call.enqueue(new Callback<image>() {
            @Override
            public void onResponse(Call<image> call, Response<image> response) {
                image imageclass = response.body();
                Toast.makeText(photo.this,"Server Responce" +imageclass.getResponse(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<image> call, Throwable t) {

            }
        });
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectedImage = data.getData();
            imageview2.setImageURI(selectedImage);
        }
    }*/

    /*
    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private class UploadImage extends AsyncTask<Void, Void, Void>{
        Bitmap image;
        public UploadImage(Bitmap image){
            this.image = image;
        }
        @TargetApi(Build.VERSION_CODES.FROYO)
        @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
        @Override
        protected Void doInBackground(Void... params) {Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);

            ArrayList<Pair<String,String>> dataToSend = new ArrayList<>();
            boolean image = dataToSend.add(new Pair<>("image", encodeImage));
            HttpParams httpRequestParams = getHttpRequestParams();
            HttpClient client = new DefaultHttpClient(httpRequestParams);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            String encodeImage =
            HttpPost post = new HttpPost(SERVER_ADDRESS + "picture.php");
            try {
                post.setEntity(new urlEncodeFromEntity(dataToSend));
                client.execute(post);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @TargetApi(Build.VERSION_CODES.CUPCAKE)
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_SHORT).show();
        }
    }
    private HttpParams getHttpRequestParams(){
        HttpParams httpRequestParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpRequestParams,1000 * 30);
        HttpConnectionParams.setSoTimeout(httpRequestParams,1000 * 30);
        return httpRequestParams;

    }


/*
    public void uploadMultipart() {
        //getting name for the image
        //String name = editText.getText().toString().trim();

        //getting the actual path of the image
        String path = getPath(filePath);

        //Uploading code
        try {
            String uploadId = UUID.randomUUID().toString();

            //Creating a multi part request
            new MultipartUploadRequest(this, uploadId, SyncStateContract.Constants.UPLOAD_URL)
                    .addFileToUpload(path, "image") //Adding file
                    //.addParameter("name", name) //Adding text parameter to the request
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(2)
                    .startUpload(); //Starting the upload

        } catch (Exception exc) {
            Toast.makeText(this, exc.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }*/
}
