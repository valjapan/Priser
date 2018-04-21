package com.valjapan.priser.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.valjapan.priser.R;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private TextView timerTextView;
    private Timer timer;

    private Handler handler = new Handler();

    private int count, period;
    private SimpleDateFormat dataFormat = new SimpleDateFormat("mm:ss", Locale.US);

    private Boolean checkTimerTask = false;

    private Button timerButton;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            count++;
            timerTextView.setText(dataFormat.format(count * period));
            handler.postDelayed(this, period);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Main Activity");

        timerTextView = (TextView) findViewById(R.id.timer_text_view);
        timerTextView.setTextColor(getColor(R.color.grey_black_1000));

        count = 0;
        period = 100;
        timerTextView.setText(dataFormat.format(0));

        timerButton = (Button) findViewById(R.id.timer_button);
        timerButton.setText("スタート");


    }


    public void next(View v) {
        if (checkTimerTask) {
            handler.removeCallbacks(runnable);
            timerTextView.setText(dataFormat.format(0));
            timerButton.setText("スタート");

            count = 0;
        } else {
            checkTimerTask = true;
            timerButton.setText("ストップ");
            handler.post(runnable);
        }


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // ここに３秒後に実行したい処理

                goPrise();


            }
        }, 3000);


    }

    public void goPrise() {
        Intent intent = new Intent(this, PriseActivity.class);
        startActivity(intent);
    }

}
