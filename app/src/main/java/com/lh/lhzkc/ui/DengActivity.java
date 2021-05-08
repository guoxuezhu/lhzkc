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
            HttpUtil.myPost("MBS62");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS62".getBytes());
        }
    }

    @OnClick(R.id.rbtn_dg_1_close)
    public void rbtn_dg_1_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS63");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS63".getBytes());
        }
    }

    @OnClick(R.id.rbtn_dg_2_open)
    public void rbtn_dg_2_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS64");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS64".getBytes());
        }
    }

    @OnClick(R.id.rbtn_dg_2_close)
    public void rbtn_dg_2_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS65");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS65".getBytes());
        }
    }

}