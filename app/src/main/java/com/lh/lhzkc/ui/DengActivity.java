package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DengActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.rbtn_dg_open)
    public void rbtn_dg_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS13");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS13".getBytes());
        }
    }

    @OnClick(R.id.rbtn_dg_close)
    public void rbtn_dg_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS14");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS14".getBytes());
        }
    }

    @OnClick(R.id.rbtn_dg_1_open)
    public void rbtn_dg_1_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS3001");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS3001".getBytes());
        }
    }

    @OnClick(R.id.rbtn_dg_1_close)
    public void rbtn_dg_1_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS3002");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS3002".getBytes());
        }
    }

    @OnClick(R.id.rbtn_dg_2_open)
    public void rbtn_dg_2_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS3003");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS3003".getBytes());
        }
    }

    @OnClick(R.id.rbtn_dg_2_close)
    public void rbtn_dg_2_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS3004");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS3004".getBytes());
        }
    }

}