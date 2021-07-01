package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.adapter.ZksDataAdapter;
import com.lh.lhzkc.data.ZksInfo;
import com.lh.lhzkc.utils.ELog;
import com.lh.lhzkc.utils.MqttManager;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DevicesActivity extends Activity implements ZksDataAdapter.CallBack {

    @BindView(R.id.devices_recyclerView)
    RecyclerView devices_recyclerView;

    private List<ZksInfo> zksInfos;
    private ZksDataAdapter mZksDataAdapter;

    private Handler devicesHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 21:
                    ELog.e("======devicesHandler=====21====");
                    Toast.makeText(DevicesActivity.this, "服务器连接失败,请检测网络", Toast.LENGTH_LONG).show();
                    break;
                case 22:
                    ELog.e("======devicesHandler=====22====");
                    initView();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);
        ButterKnife.bind(this);

        initRcyclerView();
        getZksDatas();
    }

    private void initRcyclerView() {
        zksInfos = new ArrayList<>();
        zksInfos.clear();
        devices_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mZksDataAdapter = new ZksDataAdapter(this, zksInfos, this);
        devices_recyclerView.setAdapter(mZksDataAdapter);
//        ELog.i("===========dfsEventdatas===========" + dfsEventdatas.toString());
    }

    private void initView() {
        mZksDataAdapter.setDatas(zksInfos);
    }

    @Override
    public void OnClickItem(ZksInfo zksInfo, boolean isNeiwang) {
        MyApplication.prefs.setIsip(isNeiwang);
        if (isNeiwang) {
            MyApplication.prefs.setZKIP(zksInfo.zkip);
            startActivity(new Intent(DevicesActivity.this, IpselectActivity.class));
        } else {
            if (zksInfo.zkstatus.equals("1")) {
                MyApplication.prefs.setMqttuser(zksInfo.zkname);
                startActivity(new Intent(DevicesActivity.this, MainActivity.class));
            } else {
                Toast.makeText(DevicesActivity.this, "中控外网处于关闭状态，无法使用", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void getZksDatas() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.0.100/api/get_center_list")
                .build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //4.请求加入调度，重写回调方法
        call.enqueue(new Callback() {
            //请求失败执行的方法
            @Override
            public void onFailure(Call call, IOException e) {
                ELog.e("======getZksDatas====onFailure=======" + e.toString());
                devicesHandler.sendEmptyMessage(21);
            }

            //请求成功执行的方法
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                ELog.e("=======getZksDatas===数据=======" + responseText);
                try {
                    JSONObject jsonObject = new JSONObject(responseText);
                    if (jsonObject.getInt("flag") == 1) {
                        JSONObject dataObject = jsonObject.getJSONObject("data");
                        int count = dataObject.getInt("count");
                        JSONArray jsonArray = dataObject.getJSONArray("rows");
                        ELog.e("=======getZksDatas===count=======" + count);
                        ELog.e("=======getZksDatas===jsonArray.length()=======" + jsonArray.length());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject zksjson = jsonArray.getJSONObject(i);
                            zksInfos.add(new ZksInfo(zksjson.getString("title"), zksjson.getString("ip"),
                                    zksjson.getString("show")));
                        }
                        ELog.e("=======getZksDatas===zksInfos=====" + zksInfos.toString());
                        devicesHandler.sendEmptyMessage(22);
                    } else {
                        ELog.e("=======无数据=======");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Process.killProcess(Process.myPid());
        try {
            MqttManager.getInstance().disConnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}