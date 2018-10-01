package com.example.abhi.mini_app;

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
    private Button fret;
    private EditText e1,e2,e3,e4,e5;
    private FirebaseDatabase database;
    DatabaseReference root,demo;
    academics_data ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.academics_3);
        fret = (Button)findViewById(R.id.fire_retrieve);
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





    }
}
