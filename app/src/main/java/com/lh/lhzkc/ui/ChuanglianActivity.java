package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChuanglianActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuanglian);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.rbtn_cl_open)
    public void rbtn_cl_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS3");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS3".getBytes());
        }
    }

    @OnClick(R.id.rbtn_cl_close)
    public void rbtn_cl_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS4");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS4".getBytes());
        }
    }

    @OnClick(R.id.rbtn_cl_1_open)
    public void rbtn_cl_1_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS5");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS5".getBytes());
        }
    }

    @OnClick(R.id.rbtn_cl_1_close)
    public void rbtn_cl_1_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS6");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS6".getBytes());
        }
    }

    @OnClick(R.id.rbtn_cl_2_open)
    public void rbtn_cl_2_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS7");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS7".getBytes());
        }
    }

    @OnClick(R.id.rbtn_cl_2_close)
    public void rbtn_cl_2_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS8");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS8".getBytes());
        }
    }


}