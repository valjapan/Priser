package com.valjapan.priser.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.github.bassaer.chatmessageview.model.Message;
import com.github.bassaer.chatmessageview.view.MessageView;
import com.valjapan.priser.Data.CpuMessage;
import com.valjapan.priser.Data.MotionTime;
import com.valjapan.priser.Data.User;
import com.valjapan.priser.Data.UserMessage;
import com.valjapan.priser.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;

public class PriseActivity extends AppCompatActivity {

    public Realm realm;
    public MessageView messageView;


    private String timeResult, nowTime;

    private UserMessage userData = new UserMessage();
    private CpuMessage cpuData = new CpuMessage();
    private List<Object> dataSet = new ArrayList<>();

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

        messageView = (MessageView) findViewById(R.id.message_view);


        setMessegeview();



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

    public void setMessegeview(){
        ArrayList<Message> messages = new ArrayList<>();
        RealmResults<MotionTime> results = realm.where(MotionTime.class).findAll();


        //User id
        int myId = 0;
        //User icon
        Bitmap myIcon = BitmapFactory.decodeResource(getResources(), R.drawable.face_2);
        //User name
        String myName = "User";

        int yourId = 1;
        Bitmap yourIcon = BitmapFactory.decodeResource(getResources(), R.drawable.img_icon_01);
        String yourName = "Cpu";

        final User me = new User(myId, myName, myIcon);
        final User you = new User(yourId, yourName, yourIcon);

        Message message1 = new Message.Builder()
                .setUser(me)
                .setText("AB")
                .setRight(true)
                .hideIcon(true)
                .setUsernameVisibility(false)
                .build();

        Message message2 = new Message.Builder()
                .setUser(you)
                .setText("CD")
                .setUsernameVisibility(false)
                .setRight(false)
                .build();

        messages.add(message1);
        messages.add(message2);



        messageView.setRightBubbleColor(R.color.light_blue_50);
        messageView.setLeftBubbleColor(R.color.pink_50);
        messageView.setBackgroundColor(getResources().getColor(R.color.cyan_200));
        messageView.setUsernameTextColor(R.color.grey_white_1000);
        messageView.setSendTimeTextColor(R.color.grey_white_1000);

        messageView.init(messages);
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
    protected void onDestroy(){
        super.onDestroy();

        realm.close();
    }

}