package com.valjapan.priser.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.valjapan.priser.R;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView timerTextView;

    private Handler handler = new Handler();

    private int count, period;

    private SimpleDateFormat dataFormat = new SimpleDateFormat("mm:ss", Locale.JAPAN);

    private Boolean checkTimerTask = false;

    private Button timerButton;

    private String dateString = null;


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
            checkTimerTask = false;

            SimpleDateFormat sdf = new SimpleDateFormat("mm", Locale.JAPAN);
            dateString = sdf.format(count * period);
            int stringToValue = Integer.parseInt(dateString);
            dateString = String.valueOf(stringToValue);

            handler.removeCallbacks(runnable);
            count = 0;
            period = 100;
            timerTextView.setText(dataFormat.format(0));
            timerButton.setText("スタート");


            Log.d("data", "dataString is " + dateString);

            goPrise();

            count = 0;
        } else {

            checkTimerTask = true;
            timerButton.setText("ストップ");
            handler.post(runnable);
            dateString = null;

            goPrise();
        }


    }

    public void goPrise() {
        Intent intent = new Intent(getApplicationContext(), PriseActivity.class);

        intent.putExtra("result_time",dateString);

        startActivity(intent);
    }



}
