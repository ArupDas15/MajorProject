package com.main.project.smartshop;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferenceUtil {

    public static void firstTimeAskingPermission(Context context, String permission, boolean isFirstTime, String prefName){
        SharedPreferences sharedPreference = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        sharedPreference.edit().putBoolean(permission, isFirstTime).apply();
    }
    public static boolean isFirstTimeAskingPermission(Context context, String permission, String prefName){
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE).getBoolean(permission, true);
    }
}
