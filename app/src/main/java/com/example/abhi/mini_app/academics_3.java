package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class academics_3 extends MainActivity {
    private Button fret,next,another;
    private EditText e1,e2,e3,e4,e5;
    private FirebaseDatabase database;
    DatabaseReference root,demo;
    academics_data ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.academics_33);
        fret = (Button)findViewById(R.id.fire_retrieve);
        next = (Button)findViewById(R.id.graph);
        another=(Button)findViewById(R.id.another);
        e1=(EditText)findViewById(R.id.rt1);
        e2=(EditText)findViewById(R.id.rt2);
        e3=(EditText)findViewById(R.id.rt3);
        e4=(EditText)findViewById(R.id.rt4);
        e5=(EditText)findViewById(R.id.rt5);
        final List<academics_data> specimens = new ArrayList<academics_data>();
        root =FirebaseDatabase.getInstance().getReference();
     //   String abc = e5.getText().toString().trim();
        fret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.child("student").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        for (DataSnapshot child : children) {
                            ad = child.getValue(academics_data.class);

                        }
                        e1.setText(""+ad.ms1);
                        e2.setText(""+ad.ms2);
                        e3.setText(""+ad.ms3);
                        e4.setText(""+ad.ms4);
                        e5.setText(""+ad.ms5);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        another.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(academics_3.this,Graph_Academics_1.class);
                Intent i1 =new Intent(academics_3.this,Graph_Academics_2.class);
                Intent i2 =new Intent(academics_3.this,Graph_Academics_3.class);
                Intent i3 =new Intent(academics_3.this,Graph_Academics_4.class);
                Intent i4 =new Intent(academics_3.this,Graph_Academics_5.class);
               // Intent i5 =new Intent(academics_3.this,Graph_Academics_1.class);
                int ee1 =Integer.parseInt(String.valueOf(e1.getText()));
                int ee2 =Integer.parseInt(String.valueOf(e2.getText()));
                int ee3 =Integer.parseInt(String.valueOf(e3.getText()));
                int ee4 =Integer.parseInt(String.valueOf(e4.getText()));
                int ee5 =Integer.parseInt(String.valueOf(e5.getText()));
                i.putExtra("marks1",ee1);
                i.putExtra("marks2",ee2);
                i.putExtra("marks3",ee3);
                i.putExtra("marks4",ee4);
                i.putExtra("marks5",ee5);

                i1.putExtra("marks1",ee1);
                i1.putExtra("marks2",ee2);
                i1.putExtra("marks3",ee3);
                i1.putExtra("marks4",ee4);
                i1.putExtra("marks5",ee5);

                i2.putExtra("marks1",ee1);
                i2.putExtra("marks2",ee2);
                i2.putExtra("marks3",ee3);
                i2.putExtra("marks4",ee4);
                i2.putExtra("marks5",ee5);
                startActivity(i);
            }
        });



    }
}
