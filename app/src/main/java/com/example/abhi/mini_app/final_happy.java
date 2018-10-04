package com.example.abhi.mini_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class final_happy extends MainActivity {
    EditText e11,e2,e3,e4;
    Button b11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_happy);
        e11 = (EditText)findViewById(R.id.happy_edit);
        e2 = (EditText)findViewById(R.id.happy_edit2);
        e3 = (EditText)findViewById(R.id.happy_edit3);
        e4 = (EditText)findViewById(R.id.happy_edit4);
        b11 =(Button)findViewById(R.id.hbutton);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            System.exit(0);
            }
        });
    }

}
