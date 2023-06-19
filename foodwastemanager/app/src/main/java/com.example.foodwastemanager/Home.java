package com.example.foodwastemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Home extends AppCompatActivity {


    RelativeLayout relativeLayout1,relativeLayout2,relativeLayout3,relativeLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        relativeLayout1=(RelativeLayout)findViewById(R.id.rel1);
        relativeLayout2=(RelativeLayout)findViewById(R.id.rel2);
        relativeLayout3=(RelativeLayout)findViewById(R.id.rel3);
        relativeLayout4=(RelativeLayout)findViewById(R.id.rel4);

        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Donate_food.class);
                startActivity(intent);
            }
        });

        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Display_food.class);
                startActivity(intent);
            }
        });

        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,food_managment.class);
                startActivity(intent);
            }
        });

        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,imp_food.class);
                startActivity(intent);
            }
        });
    }
}