package com.example.abhi.mini_app;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class academics_1 extends MainActivity {
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtinput,asd;
    private Button next,show;
    SQLiteDatabase db;
    int roll=0;
    String[] mstrings =new String[5];
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.academics_22);

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
                startActivity(i);

            }
        });
    }
}
