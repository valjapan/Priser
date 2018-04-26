package com.valjapan.priser.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.valjapan.priser.Adapter.PriseRecyclerViewAdapter;
import com.valjapan.priser.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PriseActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PriseRecyclerViewAdapter priseRecyclerViewAdapter;
    private ArrayList<String> detailList;

    private String timeResult;
    private TextView cpuTextView;

    final Calendar calendar = Calendar.getInstance();
    final int month = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int hour = calendar.get(Calendar.HOUR_OF_DAY);
    final int minute = calendar.get(Calendar.MINUTE);


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
        cpuTextView = (TextView) findViewById(R.id.cpu_text_view);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        detailList = new ArrayList<>();


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            timeResult = (String) bundle.get("result_time");
            resultChange();
        }
        priseRecyclerViewAdapter = new PriseRecyclerViewAdapter(getListData(), getListData());
        recyclerView.setAdapter(priseRecyclerViewAdapter);


        Log.d("prise_activity", "渡された値は " + timeResult + " です");

        Log.d("month/day hour:minute,",
                (month + 1) + "/" + day + "/" + " " + hour + ":" + minute);

    }


    private List<String> getListData() {

        if (timeResult != null) {
            detailList.add(timeResult + "分間運動した！");
//            timeList.add((month + 1) + "/" + day + "/" + " " + hour + ":" + minute);

        }

        return detailList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void resultChange() {
        cpuTextView.setText("今日もお疲れ様！ " + timeResult + "分もやったの！？すごーい！！ ");

    }

}