package com.valjapan.priser.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.valjapan.priser.Data.MotionTime;
import com.valjapan.priser.Data.NowTime;
import com.valjapan.priser.Data.UserMessage;
import com.valjapan.priser.R;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements Runnable, View.OnClickListener {
    private long startTime, endTime, diffTime;
    private TextView timerTextView;
    private final Handler handler = new Handler();
    private volatile boolean stopRun = false;
    private Button startButton, stopButton;
    private Boolean startOrFinish = true;
    private String time, cpuMessage, minutes, dateString;
    private int timeGraph;
    private Random random = new Random();
    private android.support.v7.widget.Toolbar toolbar;

    public Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        setTitle("Priser");


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

                    diffTime = (endTime - startTime);


                    int hh = (int) (diffTime / (1000 * 60 * 60)) % 24; // 時
                    int mm = (int) (diffTime / (1000 * 60)) % 60; // 分
                    int ss = (int) (diffTime / 1000) % 60; // 秒

                    time = String.format("%02d:%02d:%02d", hh, mm, ss);
//                    Log.d("Time", time);
                    timeGraph = mm + hh * 60;

                    minutes = String.valueOf(mm + hh * 60 + "分");


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

        Random random = new Random();
        int i = random.nextInt(5);

        if (i == 0) {
            cpuMessage = "今日もお疲れ様！";
        } else if (i == 1) {
            cpuMessage = minutes + "もやったの！？　えらい！";
        } else if (i == 2) {
            cpuMessage = "お疲れ様でした！";
        } else if (i == 3) {
            cpuMessage = "明日も頑張ろう！！！";
        } else if (i == 4) {
            cpuMessage = "続けられててすごい！";
        }


        realm.executeTransaction(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {

                final DateFormat df = new SimpleDateFormat("MM/dd HH:mm:ss");
                final Date date = new Date(System.currentTimeMillis());
                df.format(date);
                dateString = date.toString();

                MotionTime motionTime = realm.createObject(MotionTime.class);
                motionTime.totalScore = timeGraph;

                Log.d("NowTime", "" + timeGraph);

                NowTime nowTime = realm.createObject(NowTime.class);
                nowTime.nowToday = dateString;


                Log.d("save", time + " " + dateString);


                UserMessage userMessage = realm.createObject(UserMessage.class);
                userMessage.userDetail = "今日は" + minutes + "運動した！";
                userMessage.userTime = dateString;
                userMessage.cpuDetail = cpuMessage;
                userMessage.cpuTime = dateString;

            }
        });


    }

    public void saveMessege() {

    }


    protected void onDestroy() {
        super.onDestroy();

        realm.close();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setTitle("注意")
                    .setMessage("アプリを終了してもよろしいですか？")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 自動生成されたメソッド・スタブ
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 自動生成されたメソッド・スタブ
                        }
                    })
                    .show();
            return true;

        }

        return false;

    }
}