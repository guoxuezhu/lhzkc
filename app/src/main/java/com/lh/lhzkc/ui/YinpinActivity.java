package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

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


    Handler yphandler = new Handler() {
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
        setContentView(R.layout.activity_yinpin);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.zyl_jia)
    public void zyl_jia() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS21", yphandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS21".getBytes());
        }
    }

    @OnClick(R.id.zyl_jian)
    public void zyl_jian() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS22", yphandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS22".getBytes());
        }
    }

    @OnClick(R.id.zyl_jingyin)
    public void zyl_jingyin() {
        if (MyApplication.prefs.getIsip()) {
            if (zyl_jingyin.isChecked()) {
                HttpUtil.myPost("MBS23", yphandler);
            } else {
                HttpUtil.myPost("MBS24", yphandler);
            }
        } else {
            if (zyl_jingyin.isChecked()) {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS23".getBytes());
            } else {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS24".getBytes());
            }
        }
    }


    @OnClick(R.id.yx_jia)
    public void yx_jia() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS25", yphandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS25".getBytes());
        }
    }


    @OnClick(R.id.yx_jian)
    public void yx_jian() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS26", yphandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS26".getBytes());
        }
    }

    @OnClick(R.id.yx_jingyin)
    public void yx_jingyin() {
        if (MyApplication.prefs.getIsip()) {
            if (yx_jingyin.isChecked()) {
                HttpUtil.myPost("MBS27", yphandler);
            } else {
                HttpUtil.myPost("MBS28", yphandler);
            }
        } else {
            if (yx_jingyin.isChecked()) {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS27".getBytes());
            } else {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS28".getBytes());
            }
        }
    }

    @OnClick(R.id.mkf_jia)
    public void mkf_jia() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS29", yphandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS29".getBytes());
        }
    }


    @OnClick(R.id.mkf_jian)
    public void mkf_jian() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS30", yphandler);
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS30".getBytes());
        }
    }

    @OnClick(R.id.mkf_jingyin)
    public void mkf_jingyin() {
        if (MyApplication.prefs.getIsip()) {
            if (mkf_jingyin.isChecked()) {
                HttpUtil.myPost("MBS31", yphandler);
            } else {
                HttpUtil.myPost("MBS32", yphandler);
            }
        } else {
            if (mkf_jingyin.isChecked()) {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS31".getBytes());
            } else {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS32".getBytes());
            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        yphandler = null;
    }

}
