package com.lh.lhzkc.utils;


import android.os.Handler;
import android.os.Message;

import com.lh.lhzkc.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HttpUtil {


    private static Handler mhandler;

    public static void myPost(String zkbtnType, Handler handler) {
        mhandler = handler;
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new SignInterceptor())
                .build();

        FormBody body = new FormBody.Builder()
                .add("zkbtn", zkbtnType)
                .add("lh_zks_token", MyApplication.prefs.getAppToken())
                .add("user_name", MyApplication.prefs.getloginuser())
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

    public static class SignInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //获取原来的请求队列
            Request request = chain.request();
            //获取原来的额请求体s
            RequestBody body = request.body();
            //遍历原来的请求体到新的请求体中,并将公共参数添加到新的请求体中
            if (body != null) {
                //创建新的请求体
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                Map<String, String> signparams = postAddSignStr(body);
                for (String key : signparams.keySet()) {
                    formBodyBuilder.add(key, signparams.get(key));
                }
                return chain.proceed(request.newBuilder().post(formBodyBuilder.build()).build());
            }
            return chain.proceed(request);
        }

        private Map<String, String> postAddSignStr(RequestBody body) {
            Map<String, String> signMap = getDeviceMap();
            for (int i = 0; i < ((FormBody) body).size(); i++) {
                String name = ((FormBody) body).name(i);
                String value = ((FormBody) body).value(i);
                signMap.put(name, value);
            }
            signMap.put("sign", getSignSring(signMap));
            return signMap;
        }

        // client_id=SWQxcGJxM2RrRkoyOTAxNGU&timestamp=1611281823SXT
        private String getSignSring(Map<String, String> signMap) {
            String queryString = generateQueryString(signMap) + "SXT";
            ELog.e("=======HttpUtil===queryString=======" + queryString);
            try {
                return Coder.hashMD5(queryString.getBytes("utf8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        private String generateQueryString(Map<String, String> params) {
            if (params == null || params.isEmpty()) {
                return null;
            }
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
            return buffer.substring(1);
        }

        private static String getUtf8EscapedString(String input) {
            String result = null;
            try {
                result = URLEncoder.encode(input, "utf8");
//                result = URLEncoder.encode(input, "utf8")
//                        .replaceAll("\\+", "%20")
//                        .replaceAll("\\%21", "!")
//                        .replaceAll("\\%27", "'")
//                        .replaceAll("\\%28", "(")
//                        .replaceAll("\\%29", ")")
//                        .replaceAll("\\%7E", "~");
            } catch (UnsupportedEncodingException e) {
                return null;
            }
            return result;
        }

        private Map<String, String> getDeviceMap() {
            Map<String, String> signMap = new LinkedHashMap<String, String>();
            signMap.put("client_id", "SWQxcGJxM2RrRkoyOTAxNGU");
            signMap.put("timestamp", System.currentTimeMillis() / 1000 + "");
            return signMap;
        }
    }
}