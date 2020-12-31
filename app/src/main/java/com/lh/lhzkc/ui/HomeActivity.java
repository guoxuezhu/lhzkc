package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.ELog;
import com.lh.lhzkc.utils.MqttManager;

import org.eclipse.paho.client.mqttv3.MqttException;

import android.os.Process;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends Activity {

    private long exitTime1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

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


    @OnClick(R.id.hj_btn_layout)
    public void hj_btn_layout() {
        startActivity(new Intent(this, HuanjingActivity.class));
    }


    @OnClick(R.id.yp_btn_layout)
    public void yp_btn_layout() {
        startActivity(new Intent(this, YinpinActivity.class));
    }


    @OnClick(R.id.dy_btn_layout)
    public void dy_btn_layout() {
        startActivity(new Intent(this, DianyuanActivity.class));
    }


    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime1) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出连接", Toast.LENGTH_SHORT).show();
            exitTime1 = System.currentTimeMillis();
        } else {
            Process.killProcess(Process.myPid());
            try {
                MqttManager.getInstance().disConnect();
            } catch (MqttException e) {
                e.printStackTrace();
            }
            finish();
        }
        return;
    }
}
