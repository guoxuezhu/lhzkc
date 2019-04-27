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


    @OnClick(R.id.rbtn_cl_1_open)
    public void rbtn_cl_1_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS5".getBytes());
    }

    @OnClick(R.id.rbtn_cl_1_close)
    public void rbtn_cl_1_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS6".getBytes());
    }

    @OnClick(R.id.rbtn_cl_2_open)
    public void rbtn_cl_2_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS7".getBytes());
    }

    @OnClick(R.id.rbtn_cl_2_close)
    public void rbtn_cl_2_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS8".getBytes());
    }

    @OnClick(R.id.rbtn_tyj_open)
    public void rbtn_tyj_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS9".getBytes());
    }

    @OnClick(R.id.rbtn_tyj_close)
    public void rbtn_tyj_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS10".getBytes());
    }

    @OnClick(R.id.rbtn_tyj_bu_open)
    public void rbtn_tyj_bu_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS11".getBytes());
    }

    @OnClick(R.id.rbtn_tyj_bu_close)
    public void rbtn_tyj_bu_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS12".getBytes());
    }

    @OnClick(R.id.rbtn_dg_1_open)
    public void rbtn_dg_1_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS13".getBytes());
    }

    @OnClick(R.id.rbtn_dg_1_close)
    public void rbtn_dg_1_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS14".getBytes());
    }

    @OnClick(R.id.rbtn_dg_2_open)
    public void rbtn_dg_2_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS15".getBytes());
    }

    @OnClick(R.id.rbtn_dg_2_close)
    public void rbtn_dg_2_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS16".getBytes());
    }

    @OnClick(R.id.rbtn_dg_3_open)
    public void rbtn_dg_3_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS17".getBytes());
    }

    @OnClick(R.id.rbtn_dg_3_close)
    public void rbtn_dg_3_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS18".getBytes());
    }

    @OnClick(R.id.rbtn_dg_4_open)
    public void rbtn_dg_4_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS19".getBytes());
    }

    @OnClick(R.id.rbtn_dg_4_close)
    public void rbtn_dg_4_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS10".getBytes());
    }

    @OnClick(R.id.btn_qianmen_open)
    public void btn_qianmen_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS46".getBytes());
    }

    @OnClick(R.id.btn_houmen_open)
    public void btn_houmen_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS47".getBytes());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
