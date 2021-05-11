package com.lh.lhzkc.utils;

import com.lh.lhzkc.MyApplication;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {

    public static void myPost(String zkbtnType) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("zkbtn", zkbtnType)
                .add("lh_zks_token", MyApplication.prefs.getToken())
                .add("login_user_name", MyApplication.prefs.getLoginName())
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
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                ELog.e("=======HttpUtil===ok=======" + responseText);
            }
        });


    }
}