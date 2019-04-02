package com.lh.lhzkc;

import android.app.Application;

import com.lh.lhzkc.utils.SharePreferenceUtil;


public class MyApplication extends Application {

    public static SharePreferenceUtil prefs;


    @Override
    public void onCreate() {
        super.onCreate();
        prefs = new SharePreferenceUtil(this, "sjzkcSaveDates");
    }



}
