package com.valjapan.priser.maneger;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

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

}

