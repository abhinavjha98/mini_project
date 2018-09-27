package com.example.abhi.mini_app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class academics_3 extends MainActivity {
    private Button fret;
    private EditText e1,e2,e3,e4,e5;
    private FirebaseDatabase database;

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
        database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("https://fir-intro-45ba0.firebaseio.com/");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Map<String,String> map =dataSnapshot.getValue(Map.class);
                String marks1 =map.get("ms1");
                String marks2 =map.get("ms2");

                e1.setText(marks1);
                e2.setText(marks2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
