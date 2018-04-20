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
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prise);

        recyclerView = (RecyclerView) findViewById(R.id.priseRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        list = new ArrayList<>();


        priseRecyclerViewAdapter = new PriseRecyclerViewAdapter(getListData());
        recyclerView.setAdapter(priseRecyclerViewAdapter);

    }

    private List<String> getListData() {
        list.add("ここに結果が追加されるよ");

        return list;
    }

}