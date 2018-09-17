package com.example.abhi.mini_app;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Map;

public class Graph extends MainActivity {
    private static final String tag ="Graph";
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);
        mChart = (LineChart)findViewById(R.id.lineChart);
      //  mChart.setOnChartGestureListener(Graph.this);
       // mChart.setOnChartValueSelectedListener(Graph.this);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        ArrayList<Entry> yvalues = new ArrayList<>();

        yvalues.add(new Entry(0,60f));
        yvalues.add(new Entry(1,50f));
        yvalues.add(new Entry(2,70f));
        yvalues.add(new Entry(3,20f));
        yvalues.add(new Entry(4,90f));
        yvalues.add(new Entry(5,10f));
        LineDataSet set1=new LineDataSet(yvalues,"Data Set 1");
        set1.setFillAlpha(110);
        set1.setColor(Color.BLUE);
        set1.setLineWidth(3f);
        set1.setValueTextSize(10f);
        set1.setValueTextColor(R.color.red);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data =  new LineData(dataSets);

        mChart.setData(data);
    }
}
