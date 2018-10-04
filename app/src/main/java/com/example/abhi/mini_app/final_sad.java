package com.example.abhi.mini_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class final_sad extends MainActivity{
    EditText se1,se2,se3,se4;
    Button bs1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_sad);
        se1 = (EditText)findViewById(R.id.happy_sedit);
        se2 = (EditText)findViewById(R.id.happy_sedit2);
        se3 = (EditText)findViewById(R.id.happy_sedit3);
        se4 = (EditText)findViewById(R.id.happy_sedit4);
        bs1 =(Button)findViewById(R.id.sbutton);
        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
