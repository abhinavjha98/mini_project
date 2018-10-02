package com.example.abhi.mini_app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

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

import java.util.ArrayList;

public class Graph_Academics_1 extends MainActivity{
    private static final String tag ="Graph";
    private LineChart mChart;
    private LineChart mChart2;
    private LineChart mchart3;
    private float m1,me2,me3,me4,me5,me6;
    private float avg1,avg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph11);
        mChart = (LineChart)findViewById(R.id.lineChart1);
        mChart2=(LineChart)findViewById(R.id.lineChart2);
        mchart3 = (LineChart)findViewById(R.id.lineChart3);
        mChart.setDragEnabled(true);
        mChart2.setDragEnabled(true);
        mchart3.setDragEnabled(true);

        Intent intent = getIntent();
        m1= intent.getIntExtra("marks1",0);
        me2= intent.getIntExtra("marks2",0);
        me3= intent.getIntExtra("marks3",0);
        me4= intent.getIntExtra("marks4",0);
        me5= intent.getIntExtra("marks5",0);

        mChart.setScaleEnabled(true);
        mChart2.setScaleEnabled(true);
        mchart3.setScaleEnabled(true);


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

        YAxis leftAxis1 = mChart2.getAxisLeft();
        leftAxis1.removeAllLimitLines();
        leftAxis1.addLimitLine(upper_limit);
        leftAxis1.addLimitLine(lower_limit);
        leftAxis1.setAxisMaximum(100f);
        leftAxis1.setAxisMinimum(0f);
        leftAxis1.enableGridDashedLine(10f,10f,0f);
        leftAxis1.setDrawLimitLinesBehindData(true);
        mChart2.getAxisRight().setEnabled(false);

        YAxis leftAxis2 = mchart3.getAxisLeft();
        leftAxis2.removeAllLimitLines();
        leftAxis2.addLimitLine(upper_limit);
        leftAxis2.addLimitLine(lower_limit);
        leftAxis2.setAxisMaximum(100f);
        leftAxis2.setAxisMinimum(0f);
        leftAxis2.enableGridDashedLine(10f,10f,0f);
        leftAxis2.setDrawLimitLinesBehindData(true);
        mchart3.getAxisRight().setEnabled(false);

        ArrayList<Entry> yvalues = new ArrayList<>();
        yvalues.add(new Entry(0,m1));
        yvalues.add(new Entry(1,55f));
        float m3 = (m1+55)/2;
        yvalues.add(new Entry(2,m3));
//        yvalues.add(new Entry(3,20f));
//        yvalues.add(new Entry(4,90f));
//        yvalues.add(new Entry(5,10f));
        LineDataSet set1=new LineDataSet(yvalues,"Marks1");
        set1.setFillAlpha(110);
        set1.setColor(Color.BLUE);
        set1.setLineWidth(3f);
        set1.setValueTextSize(10f);
        set1.setValueTextColor(R.color.red);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        ArrayList<Entry> yvalues1 = new ArrayList<>();
        yvalues.add(new Entry(0,me2));
        yvalues.add(new Entry(1,60f));
        float avg1 = (m1+60)/2;
        yvalues.add(new Entry(2,avg1));
//        yvalues.add(new Entry(3,20f));
//        yvalues.add(new Entry(4,90f));
//        yvalues.add(new Entry(5,10f));
        LineDataSet set2=new LineDataSet(yvalues,"Marks2");
        set2.setFillAlpha(110);
        set2.setColor(Color.BLUE);
        set2.setLineWidth(3f);
        set2.setValueTextSize(10f);
        set2.setValueTextColor(R.color.red);
        ArrayList<ILineDataSet> dataSets1 = new ArrayList<>();
        dataSets1.add(set2);

        ArrayList<Entry> yvalues2 = new ArrayList<>();
        yvalues.add(new Entry(0,me3));
        yvalues.add(new Entry(1,40f));
        float avg2 = (m1+40)/2;
        yvalues.add(new Entry(2,avg2));
//        yvalues.add(new Entry(3,20f));
//        yvalues.add(new Entry(4,90f));
//        yvalues.add(new Entry(5,10f));
        LineDataSet set3=new LineDataSet(yvalues,"Marks1");
        set3.setFillAlpha(110);
        set3.setColor(Color.BLUE);
        set3.setLineWidth(3f);
        set3.setValueTextSize(10f);
        set3.setValueTextColor(R.color.red);
        ArrayList<ILineDataSet> dataSets2 = new ArrayList<>();
        dataSets2.add(set3);

        LineData data =  new LineData(dataSets);
        LineData data1 =  new LineData(dataSets1);
        LineData data2 =  new LineData(dataSets2);

        mChart.setData(data);
        mChart2.setData(data1);
        mchart3.setData(data2);

        String[] values = new String[]{ "Recent","Last","Predicted"};
        XAxis xAxis =mChart.getXAxis();
        xAxis.setValueFormatter(new Graph_Academics_1.MyXAxis(values));
        xAxis.setGranularity(1f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

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
