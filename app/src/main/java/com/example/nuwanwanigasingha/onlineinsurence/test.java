package com.example.nuwanwanigasingha.onlineinsurence;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class test extends AppCompatActivity {
    private APIService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final TextView textView = (TextView) findViewById(R.id.textView6);
        final Button button = (Button) findViewById(R.id.button9);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ResponseBody> call = mAPIService.hello();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> _,
                                           Response<ResponseBody> response) {
                        try {
                            textView.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                            textView.setText(e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> _, Throwable t) {
                        t.printStackTrace();
                        textView.setText(t.getMessage());
                    }
                });
            }
        });
    }
}
