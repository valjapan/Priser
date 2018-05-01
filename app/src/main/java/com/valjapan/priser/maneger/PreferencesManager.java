package com.valjapan.priser.maneger;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

public class PreferencesManager {
    private static PreferencesManager instance;
    private SharedPreferences appPreferences;
    private SharedPreferences defaultPreferences;
    //ShardPreferencesの保存部分

    public static Intent createIntent(Context context) {
        return new Intent(context, PreferencesManager.class);
    }

    private PreferencesManager(Context context) {
        appPreferences = context.getSharedPreferences("Priser", Context.MODE_PRIVATE);
        defaultPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static PreferencesManager getInstance(Context context) {
        if (instance == null) {
            instance = new PreferencesManager(context);
        }
        return instance;
    }

    public boolean isTimeLog() {
        return appPreferences.getBoolean("time_log", false);
    }
    //２回目以降チュートリアル画面に行かないように

    public void checkTutorialEnd() {
        appPreferences.edit().putBoolean("time_log", true).apply();
    }

    public int getClearCount() {
        Integer key = 1;
        return appPreferences.getInt(key, 0);
    }

    public int addClearCount(GameClientManager.Ranking ranking) {
        int clearCount = getClearCount(ranking);
        clearCount++;
        String key = getRankingKey(ranking);
        appPreferences.edit().putInt(key, clearCount).apply();
        return clearCount;
    }

    public boolean isSound() {
        return defaultPreferences.getBoolean("sound", true);
    }
    //タップ音のミュートしているかどうかの保存部分

}

