package com.valjapan.priser.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.valjapan.priser.R;

import java.util.ArrayList;
import java.util.List;

public class GraphActivity extends AppCompatActivity {
    private BarChart chart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_graph);
        setSupportActionBar(toolbar);

        setTitle("Graph Activity");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        setupBarChartView();
    }

    private void setupBarChartView() {
        chart = findViewById(R.id.graph);

        //データをセットする
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1, 60)); //<<重要：各グラフのデータ>>
        entries.add(new BarEntry(2, 30));
        entries.add(new BarEntry(3, 10));
        entries.add(new BarEntry(4, 100));
        entries.add(new BarEntry(5, 15));
        entries.add(new BarEntry(6, 20));
        entries.add(new BarEntry(7, 30));
        entries.add(new BarEntry(8, 40));
        entries.add(new BarEntry(9, 50));
        List<IBarDataSet> bars = new ArrayList<>();
        BarDataSet dataSet = new BarDataSet(entries,"Bar");

        //棒グラフの色をセット
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        bars.add(dataSet);

        //表示データセット
        BarData data = new BarData(bars);
        chart.setData(data);

        //YAxis(Left)
        YAxis left = chart.getAxisLeft();
        left.setAxisMinimum(0);
        left.setAxisMaximum(100);
        left.setLabelCount(5);
        left.setDrawTopYLabelEntry(true);

        //YAxis(Right)
        YAxis right = chart.getAxisRight();
        right.setDrawLabels(false);
        right.setDrawGridLines(false);
        right.setDrawZeroLine(true);
        right.setDrawTopYLabelEntry(true);

        //XAxis
        XAxis xAxis = chart.getXAxis();
        final String[] labels = {"","A","B","C"}; //<<重要：X軸のラベル>>
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        XAxis bottomAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        bottomAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        bottomAxis.setDrawLabels(true);
        bottomAxis.setDrawGridLines(false);
        bottomAxis.setDrawAxisLine(true);

        //グラフの設定
        chart.setDrawValueAboveBar(true);
        chart.getDescription().setEnabled(false);
        chart.setClickable(false);
        chart.getLegend().setEnabled(false);
        chart.setScaleEnabled(false);
        chart.animateY(1200, Easing.EasingOption.Linear);
    }

}
