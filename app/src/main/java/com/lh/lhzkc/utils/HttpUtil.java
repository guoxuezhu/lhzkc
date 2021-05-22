package com.lh.lhzkc.utils;

import com.lh.lhzkc.MyApplication;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {

    public static void myPost(String zkbtnType) {
        OkHttpClient okHttpClient = new OkHttpClient();
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("zkbtn", zkbtnType);
        params.put("lh_zks_token", MyApplication.prefs.getToken());
        params.put("login_user_name", MyApplication.prefs.getLoginName());

        HashMap<String, String> mapstr = getSignString(params);

        FormBody.Builder body = new FormBody.Builder();
        for (String key : mapstr.keySet()) {
            body.add(key, mapstr.get(key));
        }

        Request request = new Request.Builder()
                .url("http://" + MyApplication.prefs.getZKIP() + ":8099/api/zkczbtn")
                .post(body.build())
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

    public static HashMap<String, String> getSignString(HashMap<String, String> params) {
        params.put("client_id", "SWQxcGJxM2RrRkoyOTAxNGU");
        params.put("timestamp", System.currentTimeMillis() / 1000 + "");
        StringBuffer buffer = new StringBuffer();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            String value = params.get(key);
            if (null == value) {
                value = "";
            }
            value = getUtf8EscapedString(value);
            buffer.append("&").append(key).append("=").append(value);
        }
        String queryString = buffer.substring(1) + "SXT";
        try {
            params.put("sign", Coder.hashMD5(queryString.getBytes("utf8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    private static String getUtf8EscapedString(String input) {
        String result = null;
        try {
            result = URLEncoder.encode(input, "utf8")
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\%21", "!")
                    .replaceAll("\\%27", "'")
                    .replaceAll("\\%28", "(")
                    .replaceAll("\\%29", ")")
                    .replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return result;
    }
}