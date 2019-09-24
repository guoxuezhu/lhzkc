package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shebei);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnshangke)
    public void btnshangke() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS1".getBytes());
    }

    @OnClick(R.id.btnxiake)
    public void btnxiake() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "HBWHMBS2".getBytes());
    }

    @OnClick(R.id.btn_chaunglian)
    public void btn_chaunglian() {
        startActivity(new Intent(this, ChangjingActivity.class));
    }

    @OnClick(R.id.btn_dengguang)
    public void btn_dengguang() {
        startActivity(new Intent(this, HuanjingActivity.class));
    }

    @OnClick(R.id.btn_xinfeng)
    public void btn_xinfeng() {
        startActivity(new Intent(this, LuboActivity.class));
    }

    @OnClick(R.id.btn_qita)
    public void btn_qita() {
        startActivity(new Intent(this, DianyuanActivity.class));
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
