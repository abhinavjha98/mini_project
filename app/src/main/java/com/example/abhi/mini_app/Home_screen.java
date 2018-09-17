package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Home_screen extends MainActivity{
    private ImageView ac,tr,st,he;
    private DrawerLayout dl;
    private ActionBarDrawerToggle at;
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

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_screen.this,Graph.class);
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
                Intent i = new Intent(Home_screen.this,health_cam.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(at.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
