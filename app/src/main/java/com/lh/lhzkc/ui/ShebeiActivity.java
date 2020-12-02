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

    @OnClick(R.id.rbtn_dg_open)
    public void rbtn_dg_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS13".getBytes());
    }

    @OnClick(R.id.rbtn_dg_close)
    public void rbtn_dg_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS14".getBytes());
    }

    @OnClick(R.id.rbtn_dg_1_open)
    public void rbtn_dg_1_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS62".getBytes());
    }

    @OnClick(R.id.rbtn_dg_1_close)
    public void rbtn_dg_1_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS63".getBytes());
    }

    @OnClick(R.id.rbtn_dg_2_open)
    public void rbtn_dg_2_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS64".getBytes());
    }

    @OnClick(R.id.rbtn_dg_2_close)
    public void rbtn_dg_2_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS65".getBytes());
    }

    @OnClick(R.id.btn_qianmen_open)
    public void btn_qianmen_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MJD46".getBytes());
    }

    @OnClick(R.id.btn_houmen_open)
    public void btn_houmen_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS47".getBytes());
    }

    @OnClick(R.id.btn_dpytj_open)
    public void btn_dpytj_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS5001".getBytes());
    }

    @OnClick(R.id.btn_dpytj_close)
    public void btn_dpytj_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS5002".getBytes());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
