package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.ELog;
import com.lh.lhzkc.utils.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity {

    private String userToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_shangke)
    public void btn_shangke() {
//        HttpUtil.myPost("1");
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.1.3/sdk/LoginSystem?{\"token\":\"\",\"userName\":\"admin\",\"password\":\"admin\",\"md5Flag\":0}")
                .build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //4.请求加入调度，重写回调方法
        call.enqueue(new Callback() {
            //请求失败执行的方法
            @Override
            public void onFailure(Call call, IOException e) {

            }

            //请求成功执行的方法
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                ELog.e("==========数据=======" + responseText);


                try {
                    JSONObject jsonObject = new JSONObject(responseText);

                    ELog.e("==========数据=======" + jsonObject.getString("result"));


                    if (jsonObject.getString("result").equals("1")) {

                        JSONObject jsonObject1 = new JSONObject(jsonObject.getString("data"));

                        ELog.e("==========数据=======" + jsonObject1.getString("token"));
                        userToken = jsonObject1.getString("token");

                    }

//                    JSONArray jsonArray = new JSONArray(responseText);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


//
//                try {
//                    //将json字符串jsonData装入JSON数组，即JSONArray
//                    //jsonData可以是从文件中读取，也可以从服务器端获得
//                    JSONArray jsonArray = new JSONArray(responseText);
//                    for (int i = 0; i< jsonArray.length(); i++) {
//                        //循环遍历，依次取出JSONObject对象
//                        //用getInt和getString方法取出对应键值
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        ELog.e("==========数据==111=====" + jsonObject);
//
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        });

    }

    @OnClick(R.id.btn_xiake)
    public void btn_xiake() {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.1.3/sdk/StartRecord?token=" + userToken)
                .build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //4.请求加入调度，重写回调方法
        call.enqueue(new Callback() {
            //请求失败执行的方法
            @Override
            public void onFailure(Call call, IOException e) {

            }

            //请求成功执行的方法
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                ELog.e("==========数据=======" + responseText);


            }
        });


    }


    @OnClick(R.id.btn_stop)
    public void btn_stop() {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.1.3/sdk/StopRecord?token=" + userToken)
                .build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //4.请求加入调度，重写回调方法
        call.enqueue(new Callback() {
            //请求失败执行的方法
            @Override
            public void onFailure(Call call, IOException e) {

            }

            //请求成功执行的方法
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                ELog.e("==========数据=btn_stop======" + responseText);


            }
        });


    }


}
