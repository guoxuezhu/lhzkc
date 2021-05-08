package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_qianmen_open)
    public void btn_qianmen_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MJD46");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MJD46".getBytes());
        }
    }

    @OnClick(R.id.btn_houmen_open)
    public void btn_houmen_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS47");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS47".getBytes());
        }
    }
}