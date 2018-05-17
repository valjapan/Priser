package com.valjapan.priser.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.valjapan.priser.Data.MotionTime;
import com.valjapan.priser.Data.NowTime;
import com.valjapan.priser.R;

import java.util.ArrayList;

import io.realm.Realm;

public class GraphActivity extends AppCompatActivity {

    Realm realm;
    BarChart mBarChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        realm = Realm.getDefaultInstance();
        mBarChart = (BarChart) findViewById(R.id.graph);
        createBarChart();

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_graph);
        setSupportActionBar(toolbar);
        setTitle("Graph");

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void createBarChart() {

        mBarChart.getAxisLeft().setAxisMaxValue(60f);

        mBarChart.getAxisRight().setEnabled(false);
        mBarChart.getAxisLeft().setEnabled(true);
        mBarChart.setDrawGridBackground(true);
        mBarChart.setDrawBarShadow(false);
        mBarChart.setEnabled(true);

        mBarChart.setTouchEnabled(true);
        mBarChart.setPinchZoom(true);
        mBarChart.setDoubleTapToZoomEnabled(true);


        mBarChart.setScaleEnabled(true);

        mBarChart.getLegend().setEnabled(true);

        //X軸周り
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setLabelRotationAngle(0);

        mBarChart.setData(createBarChartData());

        mBarChart.invalidate();
        // アニメーション
        mBarChart.animateXY(2000, 2000, Easing.EasingOption.EaseInBack, Easing.EasingOption.EaseInBounce);
    }

    // BarChartの設定
    private BarData createBarChartData() {
        ArrayList<BarDataSet> barDataSets = new ArrayList<>();

        // X軸
        ArrayList<String> xValues = new ArrayList<>();

        for (NowTime nowTime : realm.where(NowTime.class).findAll()) {
            xValues.add(nowTime.nowToday);

        }


        // value
        ArrayList<BarEntry> values = new ArrayList<>();
        int i = 1;

        for (MotionTime motionTime : realm.where(MotionTime.class).findAll()) {
            values.add(new BarEntry(i, motionTime.totalScore));
            i++;
        }

        BarDataSet valuesDataSet = new BarDataSet(values, "運動した時間");

        barDataSets.add(valuesDataSet);


        BarData barData = new BarData(valuesDataSet);
        mBarChart.setData(barData);
        mBarChart.invalidate();

        mBarChart.setFitBars(true);
        return barData;

    }

}

