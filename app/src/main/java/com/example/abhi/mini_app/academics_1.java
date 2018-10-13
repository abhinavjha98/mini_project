package com.example.abhi.mini_app;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class academics_1 extends MainActivity {
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtinput,asd;
    private Button next,show;
    SQLiteDatabase db;
    int roll=0;
    DatabaseReference databaseSubject;
    String[] mstrings =new String[5];
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.academics_22);

        databaseSubject = FirebaseDatabase.getInstance().getReference("subject");
        ListView listView = (ListView)findViewById(R.id.listview_add);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(academics_1.this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        txtinput = (EditText)findViewById(R.id.textinput);
        Button b1 =(Button)findViewById(R.id.btadd);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = txtinput.getText().toString();
                mstrings[roll]=newItem;
                ++roll;
                arrayList.add(newItem);

                adapter.notifyDataSetChanged();
                txtinput.setText("");
            }
        });
        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(academics_1.this,academics_2.class);
                    i.putExtra("value1",mstrings[0]);
                i.putExtra("value2",mstrings[1]);
                i.putExtra("value3",mstrings[2]);
                i.putExtra("value4",mstrings[3]);
                i.putExtra("value5",mstrings[4]);
                addData();
                startActivity(i);

            }
        });
    }
    private void addData(){
        String s1 = mstrings[0].toString().trim();
        String s2 = mstrings[1].toString().trim();
        String s3 = mstrings[2].toString().trim();
        String s4 = mstrings[3].toString().trim();
        String s5 = mstrings[4].toString().trim();

        if(!TextUtils.isEmpty(s1)){
            //String id= databaseStudent.push().getKey();
            String id = "1";
            subject_store sData = new subject_store(id,s1,s2,s3,s4,s5);
            databaseSubject.child(id).setValue(sData);
            Toast.makeText(academics_1.this,"Added",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(academics_1.this,"PLease enter value",Toast.LENGTH_LONG).show();
        }

    }
}
