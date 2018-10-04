package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class stress_high extends MainActivity {
    Button b1;
    EditText e1,e2;
    static int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress_high);
        Intent intent = getIntent();
        value= intent.getIntExtra("Values",0);
        b1=(Button)findViewById(R.id.butstresshigh);
        e1 = (EditText)findViewById(R.id.highedit);
        e2 =(EditText)findViewById(R.id.highstress);
        e1.setText(""+value);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(stress_high.this,Home_screen.class);
                startActivity(i);
            }
        });
    }
}
