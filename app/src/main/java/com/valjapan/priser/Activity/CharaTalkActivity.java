package com.valjapan.priser.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.valjapan.priser.R;

public class CharaTalkActivity extends AppCompatActivity {
    private TextView cpuTextView;
    private Boolean tOrF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chara_talk);
        cpuTextView = findViewById(R.id.cpu_text_view);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        tOrF = (Boolean) bundle.get("check_time");
        if (tOrF) {
            cpuTextView.setText("今日も頑張ってね！");
        } else {
            cpuTextView.setText("お疲れ様でした！");
        }

        killActivity();
    }

    public void killActivity() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);
    }
}
