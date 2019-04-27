package com.lh.lhzkc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YinpinActivity extends Activity {


    @BindView(R.id.zyl_jingyin)
    CheckBox zyl_jingyin;
    @BindView(R.id.yx_jingyin)
    CheckBox yx_jingyin;
    @BindView(R.id.mkf_jingyin)
    CheckBox mkf_jingyin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yinpin);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.zyl_jia)
    public void zyl_jia() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS21".getBytes());
    }

    @OnClick(R.id.zyl_jian)
    public void zyl_jian() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS22".getBytes());
    }

    @OnClick(R.id.zyl_jingyin)
    public void zyl_jingyin() {
        if (zyl_jingyin.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS23".getBytes());
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS24".getBytes());
        }
    }


    @OnClick(R.id.yx_jia)
    public void yx_jia() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS25".getBytes());
    }


    @OnClick(R.id.yx_jian)
    public void yx_jian() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS26".getBytes());
    }

    @OnClick(R.id.yx_jingyin)
    public void yx_jingyin() {
        if (yx_jingyin.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS27".getBytes());
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS28".getBytes());
        }
    }

    @OnClick(R.id.mkf_jia)
    public void mkf_jia() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS29".getBytes());
    }


    @OnClick(R.id.mkf_jian)
    public void mkf_jian() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS30".getBytes());
    }

    @OnClick(R.id.mkf_jingyin)
    public void mkf_jingyin() {
        if (mkf_jingyin.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS31".getBytes());
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS32".getBytes());
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
