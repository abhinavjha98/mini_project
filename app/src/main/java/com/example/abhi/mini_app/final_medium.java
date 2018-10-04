package com.example.abhi.mini_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class final_medium extends MainActivity {
    EditText me1,me2,me3,me4;
    Button bm1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_medium);
        me1 = (EditText)findViewById(R.id.happy_medit);
        me2 = (EditText)findViewById(R.id.happy_medit2);
        me3 = (EditText)findViewById(R.id.happy_medit3);
        me4 = (EditText)findViewById(R.id.happy_medit4);
        bm1 =(Button)findViewById(R.id.mbutton);
        bm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            System.exit(0);
            }
        });
    }
}
