package com.example.foodwastemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class register extends AppCompatActivity {

    EditText inEmail,inPass,inConfPass;
    Button Register;
    String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inEmail=(EditText) findViewById(R.id.txtemail);
        inPass=(EditText) findViewById(R.id.txtpass);
        inConfPass=(EditText) findViewById(R.id.txtconpass);
        Register=(Button) findViewById(R.id.btnReg);
        progressDialog= new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PerforAuth();
            }
        });
    }

    private void PerforAuth() {
        String email =inEmail.getText().toString();
        String password =inPass.getText().toString();
        String Confpass = inConfPass.getText().toString();

        if(!email.matches(emailpattern)){
            inEmail.setError("Enter Correct Email");
        }else if(password.isEmpty()){
            inPass.setError("Enter Password");
        }else if(!password.equals(Confpass)){
            inConfPass.setError("Password does not matches");
        }else{
            progressDialog.setMessage("Please wait while Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUsertoHome();
                        Toast.makeText(register.this,"Regestration Successful",Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(register.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }


    }

    private void sendUsertoHome() {
        Intent intent = new Intent(register.this,Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}