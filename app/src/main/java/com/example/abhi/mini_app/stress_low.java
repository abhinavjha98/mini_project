package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class stress_low extends MainActivity {
    Button b1;
    EditText e1,e2;
    static int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress_low);
        Intent intent = getIntent();
        value= intent.getIntExtra("Values",0);
        b1=(Button)findViewById(R.id.butstresslow);
        e1 = (EditText)findViewById(R.id.scorestressedit);
        e2 =(EditText)findViewById(R.id.scorestress);
        e1.setText(""+value);
    }
}
