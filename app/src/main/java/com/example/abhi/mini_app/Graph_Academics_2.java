package com.example.abhi.mini_app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Graph_Academics_2 extends MainActivity{
    private static final String tag ="Graph";
    private LineChart mChart;
    private LineChart mChart2;
    private LineChart mchart3;
    private float m1,me2,me3,me4,me5,me6;
    private float avg1,avg2;
    private String subs2;
    DatabaseReference databaseStudent;
    DatabaseReference root,demo;
    academics_data ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_2);
        mChart = (LineChart)findViewById(R.id.lineChart2);
        mChart.setDragEnabled(true);
        Intent intent = getIntent();

        final List<academics_data> specimens = new ArrayList<academics_data>();
        root = FirebaseDatabase.getInstance().getReference();
        root.child("student").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child : children) {
                    ad = child.getValue(academics_data.class);

                }
                m1 = Float.parseFloat(ad.getMs2());
                mChart.setScaleEnabled(true);

                LimitLine upper_limit = new LimitLine(50f,"Danger");
                upper_limit.setLineWidth(4f);
                upper_limit.enableDashedLine(10f,10f,10f);
                upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
                upper_limit.setTextSize(15f);

                LimitLine lower_limit = new LimitLine(30f,"Fail");
                lower_limit.setLineWidth(4f);
                lower_limit.enableDashedLine(10f,10f,10f);
                lower_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
                lower_limit.setTextSize(15f);

                YAxis leftAxis = mChart.getAxisLeft();
                leftAxis.removeAllLimitLines();
                leftAxis.addLimitLine(upper_limit);
                leftAxis.addLimitLine(lower_limit);
                leftAxis.setAxisMaximum(100f);
                leftAxis.setAxisMinimum(0f);
                leftAxis.enableGridDashedLine(10f,10f,0f);
                leftAxis.setDrawLimitLinesBehindData(true);
                mChart.getAxisRight().setEnabled(false);

                ArrayList<Entry> yvalues = new ArrayList<>();
                yvalues.add(new Entry(0,m1));
                yvalues.add(new Entry(1,60f));
                float m3 = (m1+60)/2;
                yvalues.add(new Entry(2,m3));
//        yvalues.add(new Entry(3,20f));
//        yvalues.add(new Entry(4,90f));
//        yvalues.add(new Entry(5,10f));
                LineDataSet set1=new LineDataSet(yvalues,"Subject2");
                set1.setFillAlpha(110);
                set1.setColor(Color.BLUE);
                set1.setLineWidth(3f);
                set1.setValueTextSize(10f);
                set1.setValueTextColor(R.color.red);
                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(set1);


                LineData data =  new LineData(dataSets);


                mChart.setData(data);

                String[] values = new String[]{ "Recent","Last","Predicted"};
                XAxis xAxis =mChart.getXAxis();
                xAxis.setValueFormatter(new Graph_Academics_2.MyXAxis(values));
                xAxis.setGranularity(1f);
                xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







        Button button = (Button) findViewById(R.id.button22);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Graph_Academics_2.this, Graph_Academics_3.class);

                startActivity(i);
            }
        });

//        XAxis xAxis1 =mChart2.getXAxis();
//        xAxis.setValueFormatter(new Graph_Academics_1.MyXAxis(values));
//        xAxis.setGranularity(1f);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
//
//        XAxis xAxis2 =mchart3.getXAxis();
//        xAxis.setValueFormatter(new Graph_Academics_1.MyXAxis(values));
//        xAxis.setGranularity(1f);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

    }
    public class MyXAxis implements IAxisValueFormatter {
        private String[] mValues;
        public MyXAxis(String[] mValues){
            this.mValues=mValues;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int)value];
        }
    }
}