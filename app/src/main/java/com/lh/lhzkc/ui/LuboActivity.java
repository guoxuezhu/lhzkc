package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

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


    Handler lbhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 123:
                    MyToastshow("操作成功");
                    break;
                case 124:
                    MyToastshow("连接失败,请检测网络");
                    break;
                case 125:
                    MyToastshow("data Exception");
                    break;
            }
        }
    };

    private void MyToastshow(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lubo);

        ButterKnife.bind(this);


    }

    @OnClick(R.id.luzhi)
    public void luzhi() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("LUB1", lbhandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB1".getBytes());
        }
    }

    @OnClick(R.id.zanting)
    public void zanting() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("LUB2", lbhandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB2".getBytes());
        }
    }

    @OnClick(R.id.jixu)
    public void jixu() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("LUB6", lbhandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB6".getBytes());
        }
    }

    @OnClick(R.id.tingzhi)
    public void tingzhi() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("LUB3", lbhandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB3".getBytes());
        }
    }

    @OnClick(R.id.zhibo)
    public void zhibo() {
        if (MyApplication.prefs.getIsip()) {
            if (zhibo.isChecked()) {
                HttpUtil.myPost("LUB4", lbhandler);
            } else {
                HttpUtil.myPost("LUB5", lbhandler);
            }
        } else {
            if (zhibo.isChecked()) {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB4".getBytes());
            } else {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "LUB5".getBytes());
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        lbhandler = null;
    }
}
