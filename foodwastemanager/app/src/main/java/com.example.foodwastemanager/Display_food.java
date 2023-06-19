package com.example.foodwastemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Display_food extends AppCompatActivity{

    RecyclerView recyclerView;
    ViewAdapterModel viewAdapterModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_food);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<users> options =
                new FirebaseRecyclerOptions.Builder<users>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("users"), users.class)
                        .build();

        viewAdapterModel = new ViewAdapterModel(options);
        recyclerView.setAdapter(viewAdapterModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewAdapterModel.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewAdapterModel.stopListening();
    }
}