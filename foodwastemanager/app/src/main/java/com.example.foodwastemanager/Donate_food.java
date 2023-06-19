package com.example.foodwastemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodwastemanager.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Donate_food extends AppCompatActivity {


    EditText Ename,Efood,Eaddress,Econtact;
    String name,food,address,date,currentdate,contact;
    FirebaseDatabase db;
    DatabaseReference referencedb;
    Button upload;
    long maxid=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_food);

        //Calendar calendar = Calendar.getInstance();
        //currentdate= DateFormat.getDateInstance(DateFormat.).format(calendar.getTime());

        Date date=new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        currentdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);


        Ename=(EditText) findViewById(R.id.txtname);
        Efood=(EditText) findViewById(R.id.txtfoodtype);
        Eaddress=(EditText) findViewById(R.id.txtaddress);
        Econtact=(EditText) findViewById(R.id.txtcontact);
        upload=(Button) findViewById(R.id.btnUpl);

        referencedb = FirebaseDatabase.getInstance().getReference().child("users");


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUserData();
            }
        });

    }

    private void insertUserData() {
        name= Ename.getText().toString();
        food= Efood.getText().toString();
        address= Eaddress.getText().toString();
        contact= Econtact.getText().toString();
        date= currentdate;

        users Users = new users(name,food,address,date,contact);

        referencedb.push().setValue(Users);
        Toast.makeText(Donate_food.this,"Data Inserted",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Donate_food.this,Display_food.class);
        startActivity(intent);
        finish();
    }
}