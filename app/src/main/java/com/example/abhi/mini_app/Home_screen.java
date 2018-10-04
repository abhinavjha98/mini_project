package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Home_screen extends MainActivity{
    private ImageView ac,tr,st,he;
    private DrawerLayout dl;
    private ActionBarDrawerToggle at;
    private TextView e111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        dl =(DrawerLayout)findViewById(R.id.draw);
        at = new ActionBarDrawerToggle(Home_screen.this,dl,R.string.open,R.string.close);
        dl.addDrawerListener(at);
        at.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ac = (ImageView)findViewById(R.id.academics);
        tr =(ImageView)findViewById(R.id.tracking);
        st =(ImageView)findViewById(R.id.stress);
        he =(ImageView)findViewById(R.id.health);
        e111 = (TextView) findViewById(R.id.finals);

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_screen.this,academics_1.class);
                startActivity(i);
            }
        });
        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Home_screen.this,Main2Activity.class);
                startActivity(i2);
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Home_screen.this, stress_home.class);
                startActivity(i3);
            }
        });
        he.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Home_screen.this,health_1.class);
                startActivity(i4);
            }
        });
        e111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(Home_screen.this,final_analysis_1.class);
                startActivity(i5);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(at.onOptionsItemSelected(item)){
            if(item.getItemId()==R.id.db){
                Intent i = new Intent(Home_screen.this,academics_1.class);
                startActivity(i);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
