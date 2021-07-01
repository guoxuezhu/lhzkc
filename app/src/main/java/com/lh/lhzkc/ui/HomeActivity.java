package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import org.eclipse.paho.client.mqttv3.MqttException;

import android.os.Process;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.mb_btn_layout)
    public void mb_btn_layout() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("SKJAA");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "SKJAA" .getBytes());
        }
    }

    @OnClick(R.id.cj_btn_layout)
    public void cj_btn_layout() {
        startActivity(new Intent(this, ChangjingActivity.class));
    }

    @OnClick(R.id.sb_btn_layout)
    public void sb_btn_layout() {
        startActivity(new Intent(this, ShebeiActivity.class));
    }

    @OnClick(R.id.lb_btn_layout)
    public void lb_btn_layout() {
        startActivity(new Intent(this, LuboActivity.class));
    }

    @OnClick(R.id.jz_btn_layout)
    public void jz_btn_layout() {
        startActivity(new Intent(this, JuzhenActivity.class));
    }

    @OnClick(R.id.dg_btn_layout)
    public void dg_btn_layout() {
        startActivity(new Intent(this, DengActivity.class));
    }

    @OnClick(R.id.cl_btn_layout)
    public void cl_btn_layout() {
        startActivity(new Intent(this, ChuanglianActivity.class));
    }

    @OnClick(R.id.hj_btn_layout)
    public void hj_btn_layout() {
        startActivity(new Intent(this, HuanjingActivity.class));
    }

    @OnClick(R.id.door_btn_layout)
    public void door_btn_layout() {
        startActivity(new Intent(this, DoorActivity.class));
    }

    @OnClick(R.id.dfs_btn_layout)
    public void dfs_btn_layout() {
        startActivity(new Intent(this, DianfsActivity.class));
    }

    @OnClick(R.id.yp_btn_layout)
    public void yp_btn_layout() {
        startActivity(new Intent(this, YinpinActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (!MyApplication.prefs.getIsip()) {
            try {
                MqttManager.getInstance().disConnect();
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
        finish();
    }
}
