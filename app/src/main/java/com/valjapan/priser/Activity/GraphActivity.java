package com.valjapan.priser.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.realm.implementation.RealmBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.valjapan.priser.Data.MotionTime;
import com.valjapan.priser.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class GraphActivity extends AppCompatActivity {

    Realm realm;
    BarChart mBarChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        realm = Realm.getDefaultInstance();
        setData();

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

    }

    public List<IBarDataSet> setData() {
        RealmResults<MotionTime> results = realm.where(MotionTime.class).findAll();

        RealmBarDataSet<MotionTime> dataSet = new RealmBarDataSet<MotionTime>(results, "xValue", "yValue");

        ArrayList<IBarDataSet> dataSetList = new ArrayList<IBarDataSet>();
        dataSetList.add(dataSet);

        mBarChart = (BarChart) findViewById(R.id.graph);
        BarData data = new BarData(dataSet);
        mBarChart.setData(data);
        mBarChart.invalidate(); // refresh


        return dataSetList;

    }
}
