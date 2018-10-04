package com.example.abhi.mini_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
public class Second_Ques_Stress extends MainActivity {
    private Button b2;
    int value1,value,value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_ques_stress);
        b2=(Button)findViewById(R.id.buttonsec2);
        Intent intent = getIntent();
        value= intent.getIntExtra("Values",0);
        //Toast.makeText(this, ""+value, Toast.LENGTH_SHORT).show();
        b2.setOnClickListener(new View.OnClickListener() {
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
//                        default:
//                            value1 = 10;
                    }
                }else{
                    value1=10;
                }
                value2= value1+value;
                Intent i2 =new Intent(Second_Ques_Stress.this,Third_Ques_Stress.class);
                i2.putExtra("Values",value2);
                startActivity(i2);
            }
        });

    }
}
