package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Tenth_Ques_Stress extends MainActivity {
    private Button b;
    int value1,value,value2;
    DatabaseReference databaseStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tenth_ques_stress);
        b = (Button) findViewById(R.id.but);
        Intent intent = getIntent();
        databaseStudent = FirebaseDatabase.getInstance().getReference("stress");
        value = intent.getIntExtra("Values", 0);
        //Toast.makeText(this, ""+value, Toast.LENGTH_SHORT).show();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if(selectedId==R.id.radioButton2 ||selectedId==R.id.radioButton3 ||selectedId==R.id.radioButton4) {
                    switch (selectedId) {
                        case R.id.radioButton2:
                            value1 = 10;
                            break;
                        case R.id.radioButton3:
                            value1 = 20;
                            break;
                        case R.id.radioButton4:
                            value1 = 30;
                            break;
                    }
                }
                else{
                        value1=10;
                    }
                value2 = value1 + value;
                if (value2 < 160) {
                    Intent i = new Intent(Tenth_Ques_Stress.this, stress_low.class);
                    i.putExtra("Values", value2);
                    startActivity(i);
                } else if (value > 160 && value2 < 260) {
                    Intent i = new Intent(Tenth_Ques_Stress.this, stress_medium.class);
                    i.putExtra("Values", value2);
                    startActivity(i);
                } else {
                    Intent i = new Intent(Tenth_Ques_Stress.this, stress_high.class);
                    i.putExtra("Values", value2);
                    startActivity(i);
                }
                Toast.makeText(Tenth_Ques_Stress.this, "" + value2, Toast.LENGTH_SHORT).show();
                String id = "1";
                stress_user ss = new stress_user(value2);
                databaseStudent.child(id).setValue(ss);
                Toast.makeText(Tenth_Ques_Stress.this, "Added", Toast.LENGTH_LONG).show();

            }
        });
    }
}
