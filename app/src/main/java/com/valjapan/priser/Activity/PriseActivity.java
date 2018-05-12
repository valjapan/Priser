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

import com.github.bassaer.chatmessageview.view.MessageView;
import com.valjapan.priser.Adapter.PriseRecyclerViewAdapter;
import com.valjapan.priser.Data.CpuMessage;
import com.valjapan.priser.Data.UserMessage;
import com.valjapan.priser.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import io.realm.Realm;

public class PriseActivity extends AppCompatActivity {

    public Realm realm;
    public MessageView messageView;


    private String timeResult, nowTime;

    private UserMessage userData = new UserMessage();
    private CpuMessage cpuData = new CpuMessage();
    private List<Object> dataSet = new ArrayList<>();
    private RecyclerView recyclerView;

    final Calendar calendar = Calendar.getInstance();
    int month = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int hour = calendar.get(Calendar.HOUR_OF_DAY);
    final int minute = calendar.get(Calendar.MINUTE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prise);
        realm = Realm.getDefaultInstance();


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_prise);
        setSupportActionBar(toolbar);

        setTitle("Prise Activity");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.message_view);


        setMessageView();


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null)

        {
            timeResult = (String) bundle.get("result_time");
        }


        Log.d("prise_activity", "渡された値は " + timeResult + " です");

        getTime();
        Log.d("month/day hour:minute,", "渡された値は " + nowTime + " です");

    }

    public List<UserMessage> setMessageView() {

        LinearLayoutManager llm = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llm);


        List<UserMessage> dataset = new ArrayList<>();

        dataset.addAll(UserMessage.createDummyData());

        for (UserMessage userMessage : realm.where(UserMessage.class).findAll()) {
            dataset.add(userMessage);
        }
        PriseRecyclerViewAdapter adapter = new PriseRecyclerViewAdapter(dataset);
        recyclerView.setAdapter(adapter);

        return dataset;

    }


    private void getTime() {

        String.format("%02d", month, Locale.getDefault());
        String.format("%02d", day, Locale.getDefault());
        String.format("%02d", hour, Locale.getDefault());
        String.format("%02d", minute, Locale.getDefault());
        nowTime = (month + 1) + "/" + day + " " + hour + ":" + minute;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();

        finish();
        realm.close();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}