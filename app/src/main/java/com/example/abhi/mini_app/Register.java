package com.example.abhi.mini_app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends MainActivity {
    private EditText name,pass,phone,email;
    private Button register;
    private ProgressBar prog;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        name = (EditText)findViewById(R.id.name);
        pass = (EditText)findViewById(R.id.password);
        phone = (EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.email);
        register = (Button)findViewById(R.id.Register);
        prog = (ProgressBar)findViewById(R.id.progressBar2);
        prog.setVisibility(View.GONE);
        mAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void registerUser(){
        final String nm = name.getText().toString().trim();
        final String pw = pass.getText().toString().trim();
        final String ph = phone.getText().toString().trim();
        final String em = email.getText().toString().trim();

        if(nm.isEmpty()){
            name.setError("name required");
            name.requestFocus();
            return;
        }
        if(pw.isEmpty()){
            pass.setError("password required");
            pass.requestFocus();
            return;
        }
        if(ph.isEmpty()){
            phone.setError("phone number required");
            phone.requestFocus();
            return;
        }if(em.isEmpty()){
            email.setError("emailId required");
            email.requestFocus();
            return;
        }
        prog.setVisibility(View.VISIBLE);
    mAuth.createUserWithEmailAndPassword(em,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            prog.setVisibility(View.GONE);
            if(task.isSuccessful()){
                User user = new User(nm,em,ph,pw);
                FirebaseDatabase.getInstance().getReference("Users")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        prog.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this,"User register",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }else{
                Toast.makeText(Register.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    });
    }
}
