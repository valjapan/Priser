package com.valjapan.priser.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

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


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Prise Activity");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        recyclerView = (RecyclerView) findViewById(R.id.priseRecyclerView);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        list = new ArrayList<>();


        priseRecyclerViewAdapter = new PriseRecyclerViewAdapter(getListData());
        recyclerView.setAdapter(priseRecyclerViewAdapter);


    }


    private List<String> getListData() {
        list.add("ここに結果が追加されるよ。長く書いてみるよ。ほげほげ。");

        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_setting:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}