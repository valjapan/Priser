package com.valjapan.priser.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.valjapan.priser.R;

import java.util.Random;

public class CharaTalkAActivity extends AppCompatActivity {
    private TextView cpuTextView;
    private Boolean tOrF;
    private Random randomA = new Random();
    private Random randomD = new Random();
    private int numberA, numberD;
    private ImageView cpuImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chara_talk_a);
        cpuTextView = findViewById(R.id.cpu_text_view);
        cpuImageView = findViewById(R.id.cpu_image_a);
        numberA = randomA.nextInt(6);
        numberD = randomD.nextInt(5);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        tOrF = (Boolean) bundle.get("check_time");
        if (tOrF) {
            randomStartImage();
            cpuTextView.setText("今日も頑張ってね！");
        } else {
            randomEndImage();
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

    public void randomStartImage() {
        switch (numberA) {
            case 0:
                cpuImageView.setImageResource(R.drawable.img_a_01);
                break;
            case 1:
                cpuImageView.setImageResource(R.drawable.img_a_02);
                break;
            case 2:
                cpuImageView.setImageResource(R.drawable.img_a_03);
                break;
            case 3:
                cpuImageView.setImageResource(R.drawable.img_a_04);
                break;
            case 4:
                cpuImageView.setImageResource(R.drawable.img_a_05);
                break;
            case 5:
                cpuImageView.setImageResource(R.drawable.img_b_06);
                break;
        }
    }

    public void randomEndImage() {

        switch (numberD) {
            case 0:
                cpuImageView.setImageResource(R.drawable.img_d_01);
                break;
            case 1:
                cpuImageView.setImageResource(R.drawable.img_d_02);
                break;
            case 2:
                cpuImageView.setImageResource(R.drawable.img_d_03);
                break;
            case 3:
                cpuImageView.setImageResource(R.drawable.img_d_04);
                break;
            case 4:
                cpuImageView.setImageResource(R.drawable.img_d_05);
                break;
        }

    }

}
