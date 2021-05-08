package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
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
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS1");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS1".getBytes());
        }
    }

    @OnClick(R.id.btn_xiake)
    public void btn_xiake() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS2");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS2".getBytes());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
