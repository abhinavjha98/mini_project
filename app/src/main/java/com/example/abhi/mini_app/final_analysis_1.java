package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class final_analysis_1 extends MainActivity {
    DatabaseReference root, demo;
    academics_data ad;
    stress_user su;
    Button final_analysis, dlk;
    Integer mar1, mar2, mar3, mar4, mar5;
    Integer avg;
    Integer stres;
    Integer score;
    Integer track;
    Integer health;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_analysis_1);

        dlk = (Button) findViewById(R.id.dellk);
        final List<academics_data> specimens = new ArrayList<academics_data>();
        root = FirebaseDatabase.getInstance().getReference();
        demo = FirebaseDatabase.getInstance().getReference();

        root.child("student").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child : children) {
                    ad = child.getValue(academics_data.class);
                }
                mar1 = Integer.parseInt(ad.getMs1());
                mar2 = Integer.parseInt(ad.getMs2());
                mar3 = Integer.parseInt(ad.getMs3());
                mar4 = Integer.parseInt(ad.getMs4());
                mar5 = Integer.parseInt(ad.getMs5());
                //stres = mar1 + mar4 + mar2 + mar3 + mar5;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        final List<stress_user> ss = new ArrayList<stress_user>();

        demo.child("stress").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> childrens = dataSnapshot.getChildren();
                for (DataSnapshot child : childrens) {
                    su = child.getValue(stress_user.class);

                }
                stres = su.getValues1();
                // Toast.makeText(final_analysis_1.this,""+score,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        dlk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mar1 > 75 && mar2 > 75 && mar3 > 75 && mar4 > 75 && mar5 > 75) {
                    score = 10;
                    if (stres > 100 && stres < 160) {
                        stres = 10;
                    } else if (stres > 170 && stres < 240) {
                        stres = 6;
                    } else {
                        stres = 2;
                    }
                    track = 5;
                    health = 5;
                   // avg = score + stres + track + health;
                   // Toast.makeText(final_analysis_1.this,""+avg,Toast.LENGTH_LONG).show();
                    Intent i1 = new Intent(final_analysis_1.this,final_happy.class);
                    startActivity(i1);
                } else if (mar1 > 75 && mar2 < 45 && mar3 > 75 && mar4 < 45 && mar5 > 75) {
                    score = 8;
                    if (stres > 100 && stres < 160) {
                        stres = 10;
                    } else if (stres > 170 && stres < 240) {
                        stres = 6;
                    } else {
                        stres = 2;
                    }
                    track = 5;
                    health = 5;
                    Intent i2 = new Intent(final_analysis_1.this,final_medium.class);
                    startActivity(i2);
                }
                else if(mar1 > 75 && mar2 <45 && mar3 <45 && mar4 < 45 && mar5 < 45){
                    score = 8;
                    if (stres > 100 && stres < 160) {
                        stres = 10;
                    } else if (stres > 170 && stres < 240) {
                        stres = 6;
                    } else {
                        stres = 2;
                    }
                    track = 5;
                    health = 5;
                   // avg = score;
                   // Toast.makeText(final_analysis_1.this,""+avg,Toast.LENGTH_LONG).show();
                    Intent i3 = new Intent(final_analysis_1.this,final_sad.class);
                    startActivity(i3);
                }
                else if(mar1 < 45 && mar2 <45 && mar3 <45 && mar4 < 45 && mar5 < 45){
                    score = 8;
                    if (stres > 100 && stres < 160) {
                        stres = 10;
                    } else if (stres > 170 && stres < 240) {
                        stres = 6;
                    } else {
                        stres = 2;
                    }
                    track = 5;
                    health = 5;
                    // avg = score;
                    // Toast.makeText(final_analysis_1.this,""+avg,Toast.LENGTH_LONG).show();
                    Intent i3 = new Intent(final_analysis_1.this,final_sad.class);
                    startActivity(i3);
                }
                else if(mar1 < 45 && mar2 > 75 && mar3 <45 && mar2 < 75 && mar4 < 45){
                    score = 8;
                    if (stres > 100 && stres < 160) {
                        stres = 10;
                    } else if (stres > 170 && stres < 240) {
                        stres = 6;
                    } else {
                        stres = 2;
                    }
                    track = 5;
                    health = 5;
                    // avg = score;
                    // Toast.makeText(final_analysis_1.this,""+avg,Toast.LENGTH_LONG).show();
                    Intent i3 = new Intent(final_analysis_1.this,final_medium.class);
                    startActivity(i3);
                }
                else{
                    Toast.makeText(final_analysis_1.this,"Please enter proper details",Toast.LENGTH_LONG).show();
                }
            }
               // else if(mar1>75 && mar2>75 && mar3>75 && mar4<45 && mar5<45){
//                    score = 6;
//                    if(stres>100 && stres<160){
//                        stres = 10;
//                    }else if(stres>170 && stres<240 ){
//                        stres = 6;
//                    }else {
//                        stres = 2;
//                    }
//                    track = 5;
//                    health = 5;
//                    Toast.makeText(final_analysis_1.this,""+health+track+stres+score,Toast.LENGTH_LONG).show();
//                }
//                else if(mar1>75 && mar2>75 && mar3<45 && mar4<45 && mar5<45){
//                    score = 4;
//                    if(stres>100 && stres<160){
//                        stres = 10;
//                    }else if(stres>170 && stres<240 ){
//                        stres = 6;
//                    }else {
//                        stres = 2;
//                    }
//                    track = 5;
//                    health = 5;
//                    Toast.makeText(final_analysis_1.this,""+health+track+stres+score,Toast.LENGTH_LONG).show();
//                }else if(mar1>75 && mar2<45 && mar3<45 && mar4<45 && mar5<45){
//                    score = 2;
//                    if(stres>100 && stres<160){
//                        stres = 10;
//                    }else if(stres>170 && stres<240 ){
//                        stres = 6;
//                    }else {
//                        stres = 2;
//                    }
//                    track = 5;
//                    health = 5;
//                    Toast.makeText(final_analysis_1.this,""+health+track+stres+score,Toast.LENGTH_LONG).show();
//                }else{
//                    score = 0;
//                    if(stres>100 && stres<160){
//                        stres = 10;
//                    }else if(stres>170 && stres<240 ){
//                        stres = 6;
//                    }else {
//                        stres = 2;
//                    }
//                    track = 5;
//                    health = 5;
//                    Toast.makeText(final_analysis_1.this,""+health+track+stres+score,Toast.LENGTH_LONG).show();
//                }
//            }


        });


//        if(mar1>75 && mar2>75 &&mar3>75 &&mar4>75 && mar5>75 ){
//            score = 10;
//            if(stres>100 && stres<160){
//                stres = 10;
//            }else if(stres>170 && stres>240 ){
//                stres = 6;
//            }else {
//                stres = 2;
//            }
//            track = 5;
//            health = 5;
//            Toast.makeText(final_analysis_1.this,""+health+track+stres+score,Toast.LENGTH_LONG).show();
//        }else if(mar1>75 && mar2>75 && mar3>75 && mar4>75 && mar5<45){
//            score = 8;
//
//            if(stres>100 && stres<160){
//                stres = 10;
//            }else if(stres>170 && stres>240 ){
//                stres = 6;
//            }else {
//                stres = 2;
//            }
//            track = 5;
//            health = 5;
//        }else if(mar1>75 && mar2>75 && mar3>75 && mar4<45 && mar5<45){
//            score =6;
//            if(stres>100 && stres<160){
//                stres = 10;
//            }else if(stres>170 && stres>240 ){
//                stres = 6;
//            }else {
//                stres = 2;
//            }
//            track = 5;
//            health = 5;
//        }else if(mar1>75 && mar2>75 && mar3<45 && mar4<45 && mar5<45){
//            score = 4;
//
//            if(stres>100 && stres<160){
//                stres = 10;
//            }else if(stres>170 && stres>240 ){
//                stres = 6;
//            }else {
//                stres = 2;
//            }
//            track = 5;
//            health = 5;
//        }else if(mar1>75 && mar2>45 && mar3<45 && mar4<45 && mar5<45){
//            score = 2;
//
//            if(stres>100 && stres<160){
//                stres = 10;
//            }else if(stres>170 && stres>240 ){
//                stres = 6;
//            }else {
//                stres = 2;
//            }
//            track = 5;
//            health = 5;
//        }else if(mar1<45 && mar2<45 && mar3<45 && mar4<45 && mar5<45){
//            score = 0;
//
//            if(stres>100 && stres<160){
//                stres = 10;
//            }else if(stres>170 && stres>240 ){
//                stres = 6;
//            }else {
//                stres = 2;
//            }
//            track = 5;
//            health = 5;
//        }

//}
    }}