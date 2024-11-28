package com.example.nuwanwanigasingha.onlineinsurence;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class accident extends AppCompatActivity {
    private APIService mAPIService;
    private String license;
    public String lat = "TEST1";
    public String longt="TEST";

    private static Button photo_btn;
    private static Button location_btn;
    private static EditText vehical_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident);
        photoButton();
        mAPIService = ApiUtils.getAPIService();
        locationButton();
    }


    public void photoButton(){
        photo_btn = (Button) findViewById(R.id.button8);

        photo_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("com.example.nuwanwanigasingha.onlineinsurence.photo");
                startActivity(intent);

            }
        });

    }

    public void locationButton(){
        location_btn = (Button) findViewById(R.id.button7);
        vehical_no = (EditText)findViewById(R.id.editText);

        location_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                 license = vehical_no.getText().toString();

                mAPIService.savePost(license,lat,longt).enqueue(new Callback<post>() {
                    @Override
                    public void onResponse(Call<post> call, Response<post> response) {

                        if(response.isSuccessful()) {
                            Context context = getApplicationContext();
                            Toast.makeText(context,"send location", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<post> call, Throwable t) {
                        Toast.makeText(accident.this,"Error...", Toast.LENGTH_SHORT).show();
                    }
                });


            }


        });

    }
}
