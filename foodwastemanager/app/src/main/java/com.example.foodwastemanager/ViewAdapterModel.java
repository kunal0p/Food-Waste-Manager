package com.example.foodwastemanager;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ViewAdapterModel extends FirebaseRecyclerAdapter<users,ViewAdapterModel.myviewholder> {

    public ViewAdapterModel(@NonNull FirebaseRecyclerOptions<users> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, final int position, @NonNull users Users) {
        holder.name.setText(Users.getName().toString());
        holder.food.setText(Users.getFood().toString());
        holder.address.setText(Users.getAddress().toString());
        holder.date.setText(Users.getDate().toString());
        holder.contact.setText(Users.getContact().toString());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference().child("users")
                        .child(getRef(position).getKey()).removeValue();

            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewmodel,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView name, food, address, date, contact;
        ImageView delete;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameview);
            food = itemView.findViewById(R.id.foodview);
            address = itemView.findViewById(R.id.addressview);
            date = itemView.findViewById(R.id.dateview);
            contact = itemView.findViewById(R.id.contactview);
            delete= itemView.findViewById(R.id.deleteitem);

        }
    }

}