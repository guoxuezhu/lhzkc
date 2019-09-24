package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DianyuanActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dianyuan);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.btn_door_open)
    public void btn_door_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMJD46".getBytes());
    }

    @OnClick(R.id.btn_tyj_open)
    public void btn_tyj_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS9".getBytes());
    }

    @OnClick(R.id.btn_tyj_closed)
    public void btn_tyj_closed() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS10".getBytes());
    }

    @OnClick(R.id.btn_mb_sheng)
    public void btn_mb_sheng() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS11".getBytes());
    }

    @OnClick(R.id.btn_mb_jiang)
    public void btn_mb_jiang() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS12".getBytes());
    }

    @OnClick(R.id.btn_kt_open)
    public void btn_kt_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS39".getBytes());
    }

    @OnClick(R.id.btn_kt_closed)
    public void btn_kt_closed() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS40".getBytes());
    }

    @OnClick(R.id.btn_kt_zidong)
    public void btn_kt_zidong() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS41".getBytes());
    }

    @OnClick(R.id.btn_kt_zhileng)
    public void btn_kt_zhileng() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS42".getBytes());
    }

    @OnClick(R.id.btn_kt_zhire)
    public void btn_kt_zhire() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS43".getBytes());
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
