package com.lh.lhzkc;

import android.app.Application;
import android.content.Context;

import com.lh.lhzkc.utils.SharePreferenceUtil;


public class MyApplication extends Application {

    public static SharePreferenceUtil prefs;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        prefs = new SharePreferenceUtil(this, "sjzkcSaveDates");
    }



}
