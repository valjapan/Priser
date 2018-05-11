package com.valjapan.priser.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.valjapan.priser.R;

import java.util.Random;

public class CharaTalkBActivity extends AppCompatActivity {
    private TextView cpuTextView;
    private Boolean tOrF;
    private Random randomB = new Random();
    private Random randomC = new Random();

    private int numberB, numberC;
    private ImageView cpuImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chara_talk_b);
        cpuTextView = findViewById(R.id.cpu_text_view);
        cpuImageView = findViewById(R.id.cpu_image_b);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        numberB = randomB.nextInt(6);
        numberC = randomC.nextInt(7);
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


    public void randomStartImage() {
        switch (numberB) {
            case 0:
                cpuImageView.setImageResource(R.drawable.img_b_01);
                break;
            case 1:
                cpuImageView.setImageResource(R.drawable.img_b_02);
                break;
            case 2:
                cpuImageView.setImageResource(R.drawable.img_b_03);
                break;
            case 3:
                cpuImageView.setImageResource(R.drawable.img_b_04);
                break;
            case 4:
                cpuImageView.setImageResource(R.drawable.img_b_05);
                break;
            case 5:
                cpuImageView.setImageResource(R.drawable.img_b_06);
                break;
        }
    }

    public void randomEndImage() {

        switch (numberC) {
            case 0:
                cpuImageView.setImageResource(R.drawable.img_c_01);
                break;
            case 1:
                cpuImageView.setImageResource(R.drawable.img_c_02);
                break;
            case 2:
                cpuImageView.setImageResource(R.drawable.img_c_03);
                break;
            case 3:
                cpuImageView.setImageResource(R.drawable.img_c_04);
                break;
            case 4:
                cpuImageView.setImageResource(R.drawable.img_c_05);
                break;
            case 5:
                cpuImageView.setImageResource(R.drawable.img_c_06);
                break;
            case 6:
                cpuImageView.setImageResource(R.drawable.img_c_07);
                break;
        }

    }

    public void killActivity() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);
        Log.d("kill_activity", "正常に推移しました");
    }
}
