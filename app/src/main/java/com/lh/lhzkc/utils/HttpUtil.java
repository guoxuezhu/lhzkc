package com.lh.lhzkc.utils;


import android.os.Handler;
import android.os.Message;

import com.lh.lhzkc.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HttpUtil {


    private static Handler mhandler;

    public static void myPost(String zkbtnType, Handler handler) {
        mhandler = handler;
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("zkbtn", zkbtnType)
                .add("lh_zks_token", MyApplication.prefs.getAppToken())
                .build();

        Request request = new Request.Builder()
                .url("http://" + MyApplication.prefs.getZKIP() + ":8099/api/zkczbtn")
                .post(body)
                .build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ELog.e("======HttpUtil====onFailure=======" + e.toString());
                Message message = new Message();
                message.obj = "连接失败,请检测网络";
                message.what = 124;
                mhandler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                ELog.e("=======HttpUtil===ok=======" + responseText);
                Message message = new Message();
                try {
                    JSONObject jsonObject = new JSONObject(responseText);
                    if (jsonObject.getString("code").equals("200")) {
                        message.obj = "操作成功";
                        message.what = 124;
                    } else {
                        message.obj = jsonObject.getString("message");
                        message.what = 124;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    message.obj = responseText;
                    message.what = 124;
                }
                mhandler.sendMessage(message);
            }
        });
    }
}