package com.valjapan.priser.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.valjapan.priser.Adapter.PriseAdapter;
import com.valjapan.priser.Data.PriseData;
import com.valjapan.priser.R;

import java.util.ArrayList;
import java.util.List;

public class PriseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.priseRecyclerView);
        PriseAdapter adapter = new PriseAdapter(this.createDataset());
//
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//
//        rv.setHasFixedSize(true);
//
//        rv.setLayoutManager(llm);
//
//        rv.setAdapter(adapter);
    }

    private List<PriseData> createDataset() {

        List<PriseData> dataset = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            PriseData data = new PriseData();
            data.setDetail("カサレアル　太郎は" + i + "個の唐揚げが好き");

            dataset.add(data);
        }
        return dataset;
    }
}