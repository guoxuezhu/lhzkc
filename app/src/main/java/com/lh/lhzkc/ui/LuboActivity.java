package com.lh.lhzkc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LuboActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lubo);

        ButterKnife.bind(this);


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @OnClick(R.id.btn_xinfeng_open)
    public void btn_xinfeng_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS60".getBytes());
    }

    @OnClick(R.id.btn_xinfeng_closed)
    public void btn_xinfeng_closed() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS61".getBytes());
    }

    @OnClick(R.id.btn_xinfeng_zidong)
    public void btn_xinfeng_zidong() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS33".getBytes());
    }

    @OnClick(R.id.btn_xinfeng_sd_1)
    public void btn_xinfeng_sd_1() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS34".getBytes());
    }

    @OnClick(R.id.btn_xinfeng_sd_2)
    public void btn_xinfeng_sd_2() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS35".getBytes());
    }

    @OnClick(R.id.btn_xinfeng_sd_3)
    public void btn_xinfeng_sd_3() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS36".getBytes());
    }

}
