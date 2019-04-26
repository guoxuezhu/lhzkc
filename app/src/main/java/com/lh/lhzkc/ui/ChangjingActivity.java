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


    @OnClick(R.id.btn_shangke)
    public void btn_shangke() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "1".getBytes());
    }

    @OnClick(R.id.btn_xiake)
    public void btn_xiake() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "2".getBytes());
    }

    @OnClick(R.id.btn_zixi)
    public void btn_zixi() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "3".getBytes());
    }

    @OnClick(R.id.btn_xiuxi)
    public void btn_xiuxi() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "4".getBytes());
    }


}
