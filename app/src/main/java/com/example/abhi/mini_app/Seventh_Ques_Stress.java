package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
public class Seventh_Ques_Stress extends MainActivity {
    private Button b;
    int value1,value,value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seventh_ques_stress);
        b=(Button)findViewById(R.id.seven);
        Intent intent = getIntent();
        value= intent.getIntExtra("Values",0);
        //Toast.makeText(this, ""+value, Toast.LENGTH_SHORT).show();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                switch (selectedId)
                {
                    case R.id.radioButton2:
                        value1=10;
                        break;
                    case R.id.radioButton3:
                        value1=20;
                        break;
                    case R.id.radioButton4:
                        value1=30;
                        break;
                }
                value2= value1+value;
                Intent i2=new Intent(Seventh_Ques_Stress.this,Eight_Ques_Stress.class);
                i2.putExtra("Values",value2);
                startActivity(i2);
            }
        });

    }
}
