package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangjingActivity extends Activity {

    Handler cjhandler = new Handler() {
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
        setContentView(R.layout.activity_changjing);

        ButterKnife.bind(this);


    }


    @OnClick(R.id.btn_shangke)
    public void btn_shangke() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS1", cjhandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS1".getBytes());
        }
    }

    @OnClick(R.id.btn_xiake)
    public void btn_xiake() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS2", cjhandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS2".getBytes());
        }
    }

    //    @OnClick(R.id.btn_zixi)
//    public void btn_zixi() {
//        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS3".getBytes());
//    }
//
//    @OnClick(R.id.btn_xiuxi)
//    public void btn_xiuxi() {
//        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS4".getBytes());
//    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        cjhandler = null;
    }
}
