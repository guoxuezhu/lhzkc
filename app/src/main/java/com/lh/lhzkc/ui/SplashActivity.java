package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.OnClick;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                finish();
//            }
//        },1000);
    }

    @OnClick(R.id.btn_neiwang)
    public void btn_neiwang() {
        MyApplication.prefs.setIsip(true);
        startActivity(new Intent(SplashActivity.this, IpselectActivity.class));
        finish();
    }


    @OnClick(R.id.btn_waiwang)
    public void btn_waiwang() {
        MyApplication.prefs.setIsip(false);
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
