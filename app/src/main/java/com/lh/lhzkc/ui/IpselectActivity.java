package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.Toast;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.ELog;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class IpselectActivity extends Activity {

    @BindView(R.id.zk_ip)
    EditText zk_ip;

    Handler iphandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    baocunIp();
                    Toast.makeText(IpselectActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(IpselectActivity.this, HomeActivity.class));
                    finish();
                    break;
                case 2:
                    Toast.makeText(IpselectActivity.this, "连接失败", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipselect);
        ButterKnife.bind(this);

        zk_ip.setText(MyApplication.prefs.getZKIP());

    }

    @OnClick(R.id.btn_ip_connect)
    public void btn_ip_connect() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://" + zk_ip.getText().toString().trim() + ":8099/api/ipconnect?")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ELog.e("=========onFailure=======" + e.toString());
                iphandler.sendEmptyMessage(2);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String msg = response.body().string();
                ELog.e("========ok=======" + msg);
                iphandler.sendEmptyMessage(1);
            }
        });
    }


    private void baocunIp() {
        MyApplication.prefs.setZKIP(zk_ip.getText().toString() + "");
    }


}