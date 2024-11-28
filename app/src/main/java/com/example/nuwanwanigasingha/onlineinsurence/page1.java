package com.example.nuwanwanigasingha.onlineinsurence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class page1 extends AppCompatActivity {
    private static Button accident_btn;
    private static Button emergency_btn;
    private static Button garage_btn;
    private static Button rating_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        AccidentButton();
        EmergencyButton();
        GarageButton();
        RatingButton();
    }
    public void AccidentButton(){
        accident_btn = (Button) findViewById(R.id.button2);

        accident_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    Intent intent = new Intent("com.example.nuwanwanigasingha.onlineinsurence.accident");
                    startActivity(intent);

            }
        });

    }

    public void EmergencyButton(){
        emergency_btn = (Button) findViewById(R.id.button);

        emergency_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("com.example.nuwanwanigasingha.onlineinsurence.emvehicle");
                startActivity(intent);

            }
        });

    }

    public void GarageButton(){
        garage_btn = (Button) findViewById(R.id.button4);

        garage_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("com.example.nuwanwanigasingha.onlineinsurence.map");
                startActivity(intent);

            }
        });

    }

    public void RatingButton(){
        rating_btn = (Button) findViewById(R.id.button5);

        rating_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("com.example.nuwanwanigasingha.onlineinsurence.rating");
                startActivity(intent);

            }
        });

    }
}
