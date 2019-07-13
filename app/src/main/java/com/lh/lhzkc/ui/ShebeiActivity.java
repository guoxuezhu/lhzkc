package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.widget.CheckBox;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.MqttManager;

import org.eclipse.paho.client.mqttv3.MqttException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShebeiActivity extends Activity {

    @BindView(R.id.btnkt_kg)
    CheckBox btnkt_kg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shebei);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnshangke)
    public void btnshangke() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS1".getBytes());
    }

    @OnClick(R.id.btnxiake)
    public void btnxiake() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS2".getBytes());
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

    @OnClick(R.id.rbtn_cl_1_open)
    public void rbtn_cl_1_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS5".getBytes());
    }

    @OnClick(R.id.rbtn_cl_1_close)
    public void rbtn_cl_1_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS6".getBytes());
    }

    @OnClick(R.id.rbtn_dg_1_open)
    public void rbtn_dg_1_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS13".getBytes());
    }

    @OnClick(R.id.rbtn_dg_1_close)
    public void rbtn_dg_1_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS14".getBytes());
    }

    @OnClick(R.id.btn_qianmen_open)
    public void btn_qianmen_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MJD46".getBytes());
    }

    @OnClick(R.id.btnkt_kg)
    public void btnkt_kg() {
        if (btnkt_kg.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS39".getBytes());
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS48".getBytes());
        }
    }

    @OnClick(R.id.btnkt_wdadd)
    public void btnkt_wdadd() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS43".getBytes());
    }

    @OnClick(R.id.btnkt_wdsub)
    public void btnkt_wdsub() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS44".getBytes());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Process.killProcess(Process.myPid());//杀死进程，防止dialog.show()出现错误
        try {
            MqttManager.getInstance().disConnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
