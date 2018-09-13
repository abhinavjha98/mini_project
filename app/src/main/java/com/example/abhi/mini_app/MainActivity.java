package com.example.abhi.mini_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText email,password;
    private Button reg,log;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText)findViewById(R.id.login_email);
        password = (EditText)findViewById(R.id.login_password);
        log = (Button)findViewById(R.id.login_button);
        reg = (Button)findViewById(R.id.regi);
        mAuth = FirebaseAuth.getInstance();
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l_email =email.getText().toString().trim();
                String l_pass =password.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(l_email,l_pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Succesfully Logged in",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Please check your email Id or password",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
