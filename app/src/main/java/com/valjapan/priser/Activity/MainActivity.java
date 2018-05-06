package com.valjapan.priser.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.valjapan.priser.Data.MotionTime;
import com.valjapan.priser.R;

import java.util.Random;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements Runnable, View.OnClickListener {
    private long startTime, endTime;
    private TextView timerTextView;
    private final Handler handler = new Handler();
    private volatile boolean stopRun = false;
    private Button startButton, stopButton;
    private Boolean startOrFinish = true;
    private int numberLog;
    private Random random = new Random();
    private android.support.v7.widget.Toolbar toolbar;

    public Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        setTitle("Main Activity");


        realm = Realm.getDefaultInstance();

        timerTextView = (TextView) findViewById(R.id.timer_text_view);
        startButton = new Button(this);
        startButton = findViewById(R.id.timer_start_button);
        startButton.setOnClickListener(this);

        stopButton = new Button(this);

        stopButton = findViewById(R.id.timer_stop_button);
        stopButton.setOnClickListener(this);


        long hh = 00; // 時
        long mm = 00 / 1000 / 60; // 分
        long ss = 00 / 1000 % 60; // 秒
        String time = String.format("%1$02d:%2$02d:%3$02d", hh, mm, ss);

        timerTextView.setText(time);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_go_prise) {
            Intent intent = new Intent(this, PriseActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.menu_go_graph) {
            Intent intent = new Intent(this, GraphActivity.class);
            startActivity(intent);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Thread thread;
        if (v.getId() == R.id.timer_start_button) {
            stopRun = false;
            thread = new Thread(this);
            thread.start();

            startTime = System.currentTimeMillis();
            startButton.setVisibility(View.GONE);
            stopButton.setVisibility(View.VISIBLE);

            goStartIntent();

        } else if (v.getId() == R.id.timer_stop_button) {

            saveTime(startTime, endTime);

            stopRun = true;
            long hh = 00; // 時
            long mm = 00 / 1000 / 60; // 分
            long ss = 00 / 1000 % 60; // 秒
            String time = String.format("%1$02d:%2$02d:%3$02d", hh, mm, ss);

            timerTextView.setText(time);
            startButton.setVisibility(View.VISIBLE);
            stopButton.setVisibility(View.GONE);


            goFinishIntent();

        }
    }


    @Override
    public void run() {
        int period = 10;

        while (!stopRun) {
            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
                stopRun = true;
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    endTime = System.currentTimeMillis();
                    // カウント時間 = 経過時間 - 開始時間

                    long diffTime = (endTime - startTime);


                    long hh = (diffTime / (1000 * 60 * 60)) % 24; // 時
                    long mm = (diffTime / (1000 * 60)) % 60; // 分
                    long ss = (diffTime / 1000) % 60; // 秒
                    String time = String.format("%1$02d:%2$02d:%3$02d", hh, mm, ss);

//                    Log.d("Time", time);


                    timerTextView.setText(time);


                }
            });
        }
    }

    public void goStartIntent() {

        int i = random.nextInt(2);

        Intent intent;

        if (i == 0) {

            intent = new Intent(getApplicationContext(), CharaTalkAActivity.class);
            intent.putExtra("check_time", startOrFinish);
            startOrFinish = false;
            startActivity(intent);

        }

        if (i == 1) {

            intent = new Intent(getApplicationContext(), CharaTalkBActivity.class);
            intent.putExtra("check_time", startOrFinish);
            startOrFinish = false;
            startActivity(intent);

        }


    }

    public void goFinishIntent() {

        Random random = new Random();
        int i = random.nextInt(2);
        Intent intent;

        if (i == 0) {

            intent = new Intent(getApplicationContext(), CharaTalkAActivity.class);
            intent.putExtra("check_time", startOrFinish);
            startOrFinish = true;
            startActivity(intent);

        }

        if (i == 1) {

            intent = new Intent(getApplicationContext(), CharaTalkBActivity.class);
            intent.putExtra("check_time", startOrFinish);
            startOrFinish = true;
            startActivity(intent);

        }
    }


    public void saveTime(final Long startTime, final Long endTime) {

        MotionTime motionTime = new MotionTime();
        motionTime.startTime = startTime;
        motionTime.stopTime = endTime;


        realm.beginTransaction();
        realm.copyToRealm(motionTime);
        realm.commitTransaction();

    }

    protected void onDestroy() {
        super.onDestroy();

        realm.close();
    }


}
