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

    @BindView(R.id.zhibo)
    CheckBox zhibo;


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

    @OnClick(R.id.luzhi)
    public void luzhi() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("LUB1");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB1".getBytes());
        }
    }

    @OnClick(R.id.zanting)
    public void zanting() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("LUB2");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB2".getBytes());
        }
    }

    @OnClick(R.id.tingzhi)
    public void tingzhi() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("LUB3");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB3".getBytes());
        }
    }

    @OnClick(R.id.zhibo)
    public void zhibo() {
        if (MyApplication.prefs.getIsip()) {
            if (zhibo.isChecked()) {
                HttpUtil.myPost("LUB4");
            } else {
                HttpUtil.myPost("LUB5");
            }
        } else {
            if (zhibo.isChecked()) {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB4".getBytes());
            } else {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB5".getBytes());
            }
        }
    }


}
