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
import com.lh.lhzkc.utils.Coder;
import com.lh.lhzkc.utils.DisplayTools;
import com.lh.lhzkc.utils.ELog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class IpselectActivity extends Activity {

    @BindView(R.id.zk_ip)
    EditText zk_ip;
    @BindView(R.id.user_name)
    EditText user_name;
    @BindView(R.id.user_password)
    EditText user_password;

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
                    Toast.makeText(IpselectActivity.this, "连接失败,请检测网络", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(IpselectActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipselect);
        ButterKnife.bind(this);

        zk_ip.setText("");
        user_name.setText("");
        user_password.setText("");

    }

    @OnClick(R.id.btn_ip_connect)
    public void btn_ip_connect() {
        if (zk_ip.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "请输入设备IP", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!DisplayTools.ipCheck(zk_ip.getText().toString().trim())) {
            Toast.makeText(this, "ip地址不合法性", Toast.LENGTH_SHORT).show();
            return;
        }
        if (user_name.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "请输入帐号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (user_password.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        OkHttpClient okHttpClient = new OkHttpClient();

        String queryString = user_name.getText().toString().trim() + "SWQxcGJxM2RrRkoyOTAxNGU" + user_password.getText().toString().trim();
        String md5Password = "";
        try {
            md5Password = Coder.hashMD5(queryString.getBytes("utf8"));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "帐号或者密码存在问题", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestBody requestBody = new FormBody.Builder()
                .add("user_name", user_name.getText().toString().trim())
                .add("user_password", md5Password)
                .build();
        Request request = new Request.Builder()
                .url("http://" + zk_ip.getText().toString().trim() + ":8099/api/lh_zk_login")
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ELog.e("=========onFailure=======" + e.toString());
                iphandler.sendEmptyMessage(2);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                ELog.i("========ok=======" + responseText);
                try {
                    JSONObject jsonObject = new JSONObject(responseText);
                    if (jsonObject.getString("code").equals("200")) {
                        String apptoken = jsonObject.getString("data");
                        ELog.i("===========apptoken=======" + apptoken);
                        MyApplication.prefs.setAppToken(apptoken);
                        iphandler.sendEmptyMessage(1);
                    } else {
                        Message message = new Message();
                        message.obj = jsonObject.getString("message");
                        message.what = 3;
                        iphandler.sendMessage(message);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void baocunIp() {
        MyApplication.prefs.setZKIP(zk_ip.getText().toString().trim() + "");
    }

}