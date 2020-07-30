package com.lh.lhzkc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShebeiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shebei);

        ButterKnife.bind(this);
    }


    @OnClick(R.id.rbtn_cl_open)
    public void rbtn_cl_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS3".getBytes());
    }

    @OnClick(R.id.rbtn_cl_close)
    public void rbtn_cl_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS4".getBytes());
    }

    @OnClick(R.id.rbtn_hbd_open)
    public void rbtn_hbd_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS13".getBytes());
    }

    @OnClick(R.id.rbtn_hbd_close)
    public void rbtn_hbd_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS14".getBytes());
    }

    @OnClick(R.id.rbtn_jsd_open)
    public void rbtn_jsd_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS15".getBytes());
    }

    @OnClick(R.id.rbtn_jsd_close)
    public void rbtn_jsd_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS16".getBytes());
    }

    @OnClick(R.id.rbtn_cj_open)
    public void rbtn_cj_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS66".getBytes());
    }

    @OnClick(R.id.rbtn_cj_close)
    public void rbtn_cj_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS67".getBytes());
    }

    @OnClick(R.id.rbtn_kt_open)
    public void rbtn_kt_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS39".getBytes());
    }

    @OnClick(R.id.rbtn_kt_close)
    public void rbtn_kt_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS40".getBytes());
    }

    @OnClick(R.id.rbtn_ytj_open)
    public void rbtn_ytj_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS64".getBytes());
    }

    @OnClick(R.id.rbtn_ytj_close)
    public void rbtn_ytj_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS65".getBytes());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
