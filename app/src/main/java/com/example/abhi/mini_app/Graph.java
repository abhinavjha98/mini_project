package com.example.abhi.mini_app;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
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
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Map;

public class Graph extends MainActivity {
    private static final String tag ="Graph";
    private LineChart mChart;
    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);
        mChart = (LineChart)findViewById(R.id.lineChart);
      //  mChart.setOnChartGestureListener(Graph.this);
       // mChart.setOnChartValueSelectedListener(Graph.this);
        mChart.setDragEnabled(true);
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


        yvalues.add(new Entry(0,80f));
        yvalues.add(new Entry(1,30f));
        yvalues.add(new Entry(2,55f));
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

        LineData data =  new LineData(dataSets);

        mChart.setData(data);

        String[] values = new String[]{ "Recent","Last","Predicted"};
        XAxis  xAxis =mChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxis(values));
        xAxis.setGranularity(1f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

    }
    public class MyXAxis implements IAxisValueFormatter{
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
