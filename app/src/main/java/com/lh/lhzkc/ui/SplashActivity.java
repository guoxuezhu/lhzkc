package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.MqttManager;

import org.eclipse.paho.client.mqttv3.MqttException;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_neiwang)
    public void btn_neiwang() {
        MyApplication.prefs.setIsip(true);
        startActivity(new Intent(SplashActivity.this, IpselectActivity.class));
    }


    @OnClick(R.id.btn_waiwang)
    public void btn_waiwang() {
        MyApplication.prefs.setIsip(false);
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Process.killProcess(Process.myPid());
        try {
            MqttManager.getInstance().disConnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
