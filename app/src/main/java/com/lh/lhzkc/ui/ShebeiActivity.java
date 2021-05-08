package com.lh.lhzkc.ui;

import android.app.Activity;
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


    @OnClick(R.id.rbtn_tyj_open)
    public void rbtn_tyj_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS9");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS9".getBytes());
        }
    }

    @OnClick(R.id.rbtn_tyj_close)
    public void rbtn_tyj_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS10");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS10".getBytes());
        }
    }

    @OnClick(R.id.rbtn_tyj_bu_open)
    public void rbtn_tyj_bu_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS11");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS11".getBytes());
        }
    }

    @OnClick(R.id.rbtn_tyj_bu_close)
    public void rbtn_tyj_bu_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS12");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS12".getBytes());
        }
    }



    @OnClick(R.id.btn_dpytj_open)
    public void btn_dpytj_open() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS5001");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS5001".getBytes());
        }
    }

    @OnClick(R.id.btn_dpytj_close)
    public void btn_dpytj_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS5002");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS5002".getBytes());
        }
    }

    @OnClick(R.id.btn_dpytj_ops)
    public void btn_dpytj_ops() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS5003");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS5003".getBytes());
        }
    }

    @OnClick(R.id.btn_dpytj_hdmi)
    public void btn_dpytj_hdmi() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS5004");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS5004".getBytes());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
