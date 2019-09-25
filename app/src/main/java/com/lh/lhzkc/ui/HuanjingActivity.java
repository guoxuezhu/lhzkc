package com.lh.lhzkc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.ELog;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HuanjingActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huanjing);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.btn_dg_allopen)
    public void btn_dg_allopen() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS13".getBytes());
    }


    @OnClick(R.id.btn_dg_allclosed)
    public void btn_dg_allclosed() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS14".getBytes());
    }


    @OnClick(R.id.rbtn_dg_open_1)
    public void rbtn_dg_open_1() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS15".getBytes());
    }


    @OnClick(R.id.rbtn_dg_close_1)
    public void rbtn_dg_close_1() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS16".getBytes());
    }


    @OnClick(R.id.rbtn_dg_open_2)
    public void rbtn_dg_open_2() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS17".getBytes());
    }


    @OnClick(R.id.rbtn_dg_close_2)
    public void rbtn_dg_close_2() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS18".getBytes());
    }


    @OnClick(R.id.rbtn_dg_open_3)
    public void rbtn_dg_open_3() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS19".getBytes());
    }


    @OnClick(R.id.rbtn_dg_close_3)
    public void rbtn_dg_close_3() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS20".getBytes());
    }


    @OnClick(R.id.btn_dg_1)
    public void btn_dg_1() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS15".getBytes());
    }


    @OnClick(R.id.btn_dg_2)
    public void btn_dg_2() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS17".getBytes());
    }


    @OnClick(R.id.btn_dg_3)
    public void btn_dg_3() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS19".getBytes());
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
