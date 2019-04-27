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
    @BindView(R.id.zk_mqtt_user)
    EditText zk_mqtt_user;
    @BindView(R.id.zk_mqtt_mima)
    EditText zk_mqtt_mima;

    private String URL = "wss://cmt7p9p.mqtt.iot.gz.baidubce.com:8884/mqtt";

    private String TOPIC = "mytopic/DeviceId-numer";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getuuid();//每个客户端唯一标识


        zk_name.setText("");
        zk_mqtt_user.setText(MyApplication.prefs.getMqttuser());
        zk_mqtt_mima.setText(MyApplication.prefs.getMqttMima());


    }

    private void getuuid() {
        if (MyApplication.prefs.getUdid() == null) {
            MyApplication.prefs.setUdid(java.util.UUID.randomUUID().toString());
        }
    }

    @OnClick(R.id.btn_connect)
    public void btn_connect() {
        if (zk_name.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "请输入中控位置", Toast.LENGTH_SHORT).show();
            return;
        }

        if (zk_mqtt_user.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "请输入MQTT用户", Toast.LENGTH_SHORT).show();
            return;
        }

        if (zk_mqtt_mima.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "请输入MQTT密码", Toast.LENGTH_SHORT).show();
            return;
        }

        MyApplication.prefs.setMqttuser(zk_mqtt_user.getText().toString().trim());
        MyApplication.prefs.setMqttMima(zk_mqtt_mima.getText().toString().trim());
        MyApplication.prefs.setzkname(TOPIC + zk_name.getText().toString().trim());

        boolean subscriber = MqttManager.getInstance().creatConnect(URL, MyApplication.prefs.getMqttuser(),
                MyApplication.prefs.getMqttMima(), MyApplication.prefs.getUdid());
        if (subscriber) {
            Toast.makeText(this, "连接成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }

    }

}
