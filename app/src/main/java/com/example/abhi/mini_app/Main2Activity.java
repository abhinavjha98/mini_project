package com.example.abhi.mini_app;

import android.app.Activity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;

public class Main2Activity extends Activity {

    static  ArrayList<String> places = new ArrayList<String>();
    static ArrayList<LatLng> location= new ArrayList<LatLng>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView = (ListView) findViewById(R.id.listView);
        SharedPreferences sharedPreferences= this.getSharedPreferences("com.example.abhi.mini_app", Context.MODE_PRIVATE);
        ArrayList<String>latitudes = new ArrayList<String>();
        ArrayList<String>longitudes = new ArrayList<String>();
        places.clear();
        latitudes.clear();
        longitudes.clear();
        try {
            places = (ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("places",ObjectSerializer.serialize(new ArrayList<String>())));
            latitudes = (ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("latitudes",ObjectSerializer.serialize(new ArrayList<String>())));
            longitudes = (ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("longitudes",ObjectSerializer.serialize(new ArrayList<String>())));

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (places.size()>0 && latitudes.size()>0 && longitudes.size()>0){
            if (places.size()==latitudes.size() && longitudes.size()==latitudes.size()){
                for(int i=0;i<latitudes.size();i++)
                {
                    location.add(new LatLng(Double.parseDouble(latitudes.get(i)),Double.parseDouble(longitudes.get(i))));
                }
            }
        }else {
            places.add("Add a new place");
            location.add(new LatLng(0, 0));
        }
        Log.i("ArrayList :",places.toString());
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,places);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("PlaceNo", i);
                startActivity(intent);
            }
        });

    }
}