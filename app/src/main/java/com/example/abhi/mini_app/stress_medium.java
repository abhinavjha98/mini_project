package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class stress_medium extends MainActivity {
    Button b1;
    EditText e1,e2;
    static int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress_medium);
        Intent intent = getIntent();
        value= intent.getIntExtra("Values",0);
        b1=(Button)findViewById(R.id.butstressmedium);
        e1 = (EditText)findViewById(R.id.mediumedit);
        e2 =(EditText)findViewById(R.id.mediumstress);
        e1.setText(""+value);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(stress_medium.this,Home_screen.class);
                startActivity(i);
            }
        });
    }
}
