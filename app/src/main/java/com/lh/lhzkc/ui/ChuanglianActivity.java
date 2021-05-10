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
            HttpUtil.myPost("MBS1001");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS1001".getBytes());
        }
    }

    @OnClick(R.id.rbtn_cl_1_close)
    public void rbtn_cl_1_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS1002");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS1002".getBytes());
        }
    }

    @OnClick(R.id.rbtn_cl_2_open)
    public void rbtn_cl_2_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS1004");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS1004".getBytes());
        }
    }

    @OnClick(R.id.rbtn_cl_2_close)
    public void rbtn_cl_2_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS1005");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS1005".getBytes());
        }
    }


}