package com.example.abhi.mini_app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class academics_2 extends MainActivity {
    private Button b1;
    private TextView t1,t2,t3,t4,t5;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
        b1=(Button)findViewById(R.id.retrieve_data);
        t1=(TextView)findViewById(R.id.subject_1);
        t2=(TextView)findViewById(R.id.subject_2);
        t3=(TextView)findViewById(R.id.subject_3);
        t4=(TextView)findViewById(R.id.subject_4);
        t5=(TextView)findViewById(R.id.subject_5);
        db = openOrCreateDatabase("Student", Context.MODE_PRIVATE,null);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String m0 = extras.getString("value1");
            String m1 = extras.getString("value2");
            String m2 = extras.getString("value3");
            String m3 = extras.getString("value4");
            String m4 = extras.getString("value5");
            t1.setText("Enter your "+m0 +" marks");
            t2.setText("Enter your "+m1 +" marks");
            t3.setText("Enter your "+m2 +" marks");
            t4.setText("Enter your "+m3 +" marks");
            t5.setText("Enter your "+m4 +" marks");
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
