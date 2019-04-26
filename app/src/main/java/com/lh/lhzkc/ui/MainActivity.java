package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {


    @BindView(R.id.zk_name)
    EditText zk_name;


    private String URL = "wss://cmt7p9p.mqtt.iot.gz.baidubce.com:8884/mqtt";
    private String userName = "cmt7p9p/zk_user_1";
    private String password = "vZakahehxugRHnZs";

    private String clientId;//每个客户端唯一标识

    private String TOPIC = "mytopic/DeviceId-numer";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        clientId = getuuid();//每个客户端唯一标识


        zk_name.setText("");


    }

    private String getuuid() {
        if (MyApplication.prefs.getUdid() == null) {
            MyApplication.prefs.setUdid(java.util.UUID.randomUUID().toString());
        }
        return MyApplication.prefs.getUdid();
    }

    @OnClick(R.id.btn_connect)
    public void btn_connect() {
        if (zk_name.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "请输入中控位置", Toast.LENGTH_SHORT).show();
            return;
        }
        MyApplication.prefs.setzkname(TOPIC + zk_name.getText().toString().trim());

        boolean subscriber = MqttManager.getInstance().creatConnect(URL, userName, password, clientId);
        if (subscriber) {
//            boolean publish = MqttManager.getInstance().publish(TOPIC, 0, "".getBytes());
//            if (publish) {
//                Toast.makeText(this, "连接成功", Toast.LENGTH_SHORT).show();
//            }
            Toast.makeText(this, "连接成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HomeActivity.class));
        }

    }

}
