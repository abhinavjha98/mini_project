package com.example.abhi.mini_app;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class academics_2 extends MainActivity {
    private Button b1,b2;
    private TextView t1,t2,t3,t4,t5;
    private TextView m1,m2,m3,m4,m5;
    SQLiteDatabase db;
    DatabaseReference databaseStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.academics_2_sample);
        b1=(Button)findViewById(R.id.retrieve_data);
        t1=(TextView)findViewById(R.id.subject_1);
        t2=(TextView)findViewById(R.id.subject_2);
        t3=(TextView)findViewById(R.id.subject_3);
        t4=(TextView)findViewById(R.id.subject_4);
        t5=(TextView)findViewById(R.id.subject_5);

       databaseStudent = FirebaseDatabase.getInstance().getReference("student");

        m1=(TextView)findViewById(R.id.marks1);
        m2=(TextView)findViewById(R.id.marks2);
        m3=(TextView)findViewById(R.id.marks3);
        m4=(TextView)findViewById(R.id.marks4);
        m5=(TextView)findViewById(R.id.marks5);
        b2=(Button)findViewById(R.id.datas);

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
            addData();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(academics_2.this,academics_3.class);
                startActivity(i);
            }
        });
    }
    private void addData(){
        String marks1 = m1.getText().toString().trim();
        String marks2 = m2.getText().toString().trim();
        String marks3 = m3.getText().toString().trim();
        String marks4 = m4.getText().toString().trim();
        String marks5 = m5.getText().toString().trim();

        if(!TextUtils.isEmpty(marks1)){
            //String id= databaseStudent.push().getKey();
            String id = "1";
            academics_data academicsData = new academics_data(id,marks1,marks2,marks3,marks4,marks5);
            databaseStudent.child(id).setValue(academicsData);
            Toast.makeText(academics_2.this,"Added",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(academics_2.this,"PLease enter value",Toast.LENGTH_LONG).show();
        }

    }
}
