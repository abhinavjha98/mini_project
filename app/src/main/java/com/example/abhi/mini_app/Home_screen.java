package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home_screen extends MainActivity{
    private ImageView ac,tr,st,he;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        ac = (ImageView)findViewById(R.id.academics);
        tr =(ImageView)findViewById(R.id.tracking);
        st =(ImageView)findViewById(R.id.stress);
        he =(ImageView)findViewById(R.id.health);

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_screen.this,academics.class);
                startActivity(i);
            }
        });
        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_screen.this,tracking.class);
                startActivity(i);
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_screen.this,stress.class);
                startActivity(i);
            }
        });
        he.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_screen.this,health.class);
                startActivity(i);
            }
        });
    }
}
