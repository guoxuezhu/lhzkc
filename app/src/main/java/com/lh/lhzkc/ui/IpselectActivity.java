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
import com.lh.lhzkc.utils.ELog;
import com.lh.lhzkc.utils.HttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class IpselectActivity extends Activity {

    @BindView(R.id.zk_ip)
    EditText zk_ip;

    @BindView(R.id.zk_login_name)
    EditText zk_login_name;

    @BindView(R.id.zk_login_mima)
    EditText zk_login_mima;

    Handler iphandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    startActivity(new Intent(IpselectActivity.this, HomeActivity.class));
                    finish();
                    break;
                case 2:
                    Toast.makeText(IpselectActivity.this, "连接失败，请检查网络", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(IpselectActivity.this, "请确认信息是否正确，重新连接", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
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

        zk_ip.setText(MyApplication.prefs.getZKIP());

    }

    @OnClick(R.id.btn_ip_connect)
    public void btn_ip_connect() {
        String queryString = zk_login_name.getText().toString().trim() + "SWQxcGJxM2RrRkoyOTAxNGU" + zk_login_mima.getText().toString().trim();
        String md5Password = "";
        try {
            md5Password = Coder.hashMD5(queryString.getBytes("utf8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient();
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("user_name", zk_login_name.getText().toString().trim());
        params.put("user_password", md5Password);

        HashMap<String, String> mapstr = HttpUtil.getSignString(params);

        FormBody.Builder body = new FormBody.Builder();
        for (String key : mapstr.keySet()) {
            body.add(key, mapstr.get(key));
        }

        Request request = new Request.Builder()
                .url("http://" + zk_ip.getText().toString().trim() + ":8099/api/lh_zk_login")
                .post(body.build())
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
                try {
                    JSONObject jsonObject = new JSONObject(msg);
                    if (jsonObject.getBoolean("success")) {
                        MyApplication.prefs.setZKIP(zk_ip.getText().toString() + "");
                        MyApplication.prefs.setLoginName(zk_login_name.getText().toString().trim());
                        ELog.d("========setToken=======" + jsonObject.getString("data"));
                        MyApplication.prefs.setToken(jsonObject.getString("data"));
                        iphandler.sendEmptyMessage(1);
                    } else {
                        Message message = new Message();
                        message.obj = jsonObject.getString("message");
                        message.what = 4;
                        iphandler.sendMessage(message);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    iphandler.sendEmptyMessage(3);
                }

            }
        });
    }

}