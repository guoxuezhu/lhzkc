package com.lh.lhzkc.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.ELog;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {


    @BindView(R.id.zk_name)
    EditText zk_name;

    private String URL = "wss://uc5xuva.mqtt.iot.gz.baidubce.com:8884/mqtt";

    private String TOPIC = "lhzktopic/device";
    private ProgressDialog progressDialog;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }
                    Toast.makeText(MainActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    finish();
                    break;
                case 2:
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }
                    Toast.makeText(MainActivity.this, "连接失败", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getuuid();//每个客户端唯一标识


        zk_name.setText("");


    }

    private void getuuid() {
        if (MyApplication.prefs.getUdid() == null) {
            MyApplication.prefs.setUdid(java.util.UUID.randomUUID().toString());
        }
    }

    @OnClick(R.id.btn_connect)
    public void btn_connect() {
        if (zk_name.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "请输入设备名称", Toast.LENGTH_SHORT).show();
            return;
        }

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.show();
        progressDialog.setMessage("连接中.......");
        progressDialog.setCanceledOnTouchOutside(false);

        new Thread() {
            @Override
            public void run() {
                super.run();

                MyApplication.prefs.setzkname(TOPIC + zk_name.getText().toString().trim());
                MyApplication.prefs.setMqttuser(zk_name.getText().toString().trim());

                boolean subscriber = MqttManager.getInstance().creatConnect(URL, "uc5xuva/admin",
                        "aYBMf7Ci9eCKkx57", MyApplication.prefs.getUdid());

                ELog.d("========111==========" + subscriber);
                if (subscriber) {
                    handler.sendEmptyMessage(1);
                } else {
                    handler.sendEmptyMessage(2);
                }


            }
        }.start();


    }


}
