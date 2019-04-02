package com.lh.lhzkc.utils;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 打印log日志
 */
public class HttpUtil {


    public static void myPost(String zkbtnType) {

        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("zkbtn", zkbtnType)
                .build();

        Request request = new Request.Builder()
                .url("http://192.168.1.5:8099")
                .post(body)
                .build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                ELog.e("==========数据=======" + responseText);
            }
        });





    }
}