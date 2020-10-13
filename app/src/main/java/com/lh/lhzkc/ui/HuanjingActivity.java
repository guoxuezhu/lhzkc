package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.ELog;
import com.lh.lhzkc.utils.MqttManager;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HuanjingActivity extends Activity {


    @BindView(R.id.tv_wsd_wd)
    TextView tv_wsd_wd;
    @BindView(R.id.tv_wsd_sd)
    TextView tv_wsd_sd;
    @BindView(R.id.tv_wsd_pm)
    TextView tv_wsd_pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huanjing);

        ButterKnife.bind(this);

        InitView();

    }

    private void InitView() {

        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("zkbtn", "wsd")
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
                ELog.e("======wsd====onFailure=======" + e.toString());
                tv_wsd_wd.setText("0");
                tv_wsd_sd.setText("0");
                tv_wsd_pm.setText("0");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String msg = response.body().string();
                ELog.e("=======wsd===ok=======" + msg);
                String[] msglist = msg.split(";");
                tv_wsd_wd.setText(msglist[1]);
                tv_wsd_sd.setText(msglist[2]);
                tv_wsd_pm.setText("0");


            }
        });

    }



    @OnClick(R.id.rbtn_cl_open)
    public void rbtn_cl_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS3".getBytes());
    }


    @OnClick(R.id.rbtn_cl_close)
    public void rbtn_cl_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS4".getBytes());
    }


    @OnClick(R.id.rbtn_hbd_open)
    public void rbtn_hbd_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS62".getBytes());
    }

    @OnClick(R.id.rbtn_hbd_close)
    public void rbtn_hbd_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS63".getBytes());
    }

    @OnClick(R.id.rbtn_jsd_open)
    public void rbtn_jsd_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS64".getBytes());
    }

    @OnClick(R.id.rbtn_jsd_close)
    public void rbtn_jsd_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS65".getBytes());
    }

    @OnClick(R.id.rbtn_cj_open)
    public void rbtn_cj_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS66".getBytes());
    }

    @OnClick(R.id.rbtn_cj_close)
    public void rbtn_cj_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS67".getBytes());
    }



    @OnClick(R.id.rbtn_tyj_open)
    public void rbtn_tyj_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS9".getBytes());
    }

    @OnClick(R.id.rbtn_tyj_close)
    public void rbtn_tyj_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS10".getBytes());
    }

    @OnClick(R.id.rbtn_tyj_bu_open)
    public void rbtn_tyj_bu_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS11".getBytes());
    }

    @OnClick(R.id.rbtn_tyj_bu_close)
    public void rbtn_tyj_bu_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS12".getBytes());
    }



    @OnClick(R.id.rbtn_kt_open)
    public void rbtn_kt_open() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS39".getBytes());
    }

    @OnClick(R.id.rbtn_kt_close)
    public void rbtn_kt_close() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS40".getBytes());
    }

    @OnClick(R.id.rbtn_kt_ms)
    public void rbtn_kt_ms() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS41".getBytes());
    }

    @OnClick(R.id.rbtn_mj_door)
    public void rbtn_mj_door() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS46".getBytes());
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
