package com.valjapan.priser.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.valjapan.priser.Adapter.PriseRecyclerViewAdapter;
import com.valjapan.priser.R;

import java.util.ArrayList;
import java.util.List;

public class PriseActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PriseRecyclerViewAdapter priseRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.priseRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        priseRecyclerViewAdapter = new PriseRecyclerViewAdapter(getListData());
        recyclerView.setAdapter(priseRecyclerViewAdapter);

    }

    private List<String> getListData(){
        ArrayList<String> list = new ArrayList<>();
    }

}