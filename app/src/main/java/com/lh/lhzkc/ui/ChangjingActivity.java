package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangjingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changjing);

        ButterKnife.bind(this);


    }


    @OnClick(R.id.btn_cl_allopen)
    public void btn_cl_allopen() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS3".getBytes());
    }

    @OnClick(R.id.btn_cl_allclosed)
    public void btn_cl_allclosed() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS4".getBytes());
    }


    @OnClick(R.id.rbtn_cl_open_1)
    public void rbtn_cl_open_1() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS5".getBytes());
    }


    @OnClick(R.id.rbtn_cl_stop_1)
    public void rbtn_cl_stop_1() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS55".getBytes());
    }


    @OnClick(R.id.rbtn_cl_close_1)
    public void rbtn_cl_close_1() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS6".getBytes());
    }


    @OnClick(R.id.rbtn_cl_open_2)
    public void rbtn_cl_open_2() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS7".getBytes());
    }


    @OnClick(R.id.rbtn_cl_stop_2)
    public void rbtn_cl_stop_2() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS56".getBytes());
    }


    @OnClick(R.id.rbtn_cl_close_2)
    public void rbtn_cl_close_2() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS8".getBytes());
    }


    @OnClick(R.id.rbtn_cl_open_3)
    public void rbtn_cl_open_3() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS62".getBytes());
    }


    @OnClick(R.id.rbtn_cl_stop_3)
    public void rbtn_cl_stop_3() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS57".getBytes());
    }


    @OnClick(R.id.rbtn_cl_close_3)
    public void rbtn_cl_close_3() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS63".getBytes());
    }


    @OnClick(R.id.rbtn_cl_open_4)
    public void rbtn_cl_open_4() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS64".getBytes());
    }


    @OnClick(R.id.rbtn_cl_stop_4)
    public void rbtn_cl_stop_4() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS58".getBytes());
    }


    @OnClick(R.id.rbtn_cl_close_4)
    public void rbtn_cl_close_4() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS65".getBytes());
    }


    @OnClick(R.id.rbtn_cl_open_5)
    public void rbtn_cl_open_5() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS66".getBytes());
    }


    @OnClick(R.id.rbtn_cl_stop_5)
    public void rbtn_cl_stop_5() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS59".getBytes());
    }


    @OnClick(R.id.rbtn_cl_close_5)
    public void rbtn_cl_close_5() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS67".getBytes());
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
