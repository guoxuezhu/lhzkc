package com.lh.lhzkc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.ELog;
import com.lh.lhzkc.utils.HttpUtil;
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

    @BindView(R.id.huanjng_btn_kaiguan)
    CheckBox huanjng_btn_kaiguan;

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


    @OnClick(R.id.huanjng_btn_kaiguan)
    public void huanjng_btn_kaiguan() {
        if (huanjng_btn_kaiguan.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS39".getBytes());
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS40".getBytes());
        }
    }


    @OnClick(R.id.huanjng_btn_moshi)
    public void huanjng_btn_moshi() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS41".getBytes());
    }


    @OnClick(R.id.huanjng_btn_fengsu)
    public void huanjng_btn_fengsu() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS44".getBytes());
    }


//    @OnClick(R.id.huanjng_btn_wd_jia)
//    public void huanjng_btn_wd_jia() {
//        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS43".getBytes());
//    }
//
//
//    @OnClick(R.id.huanjng_btn_wd_jian)
//    public void huanjng_btn_wd_jian() {
//        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS44".getBytes());
//    }
//
//
//    @OnClick(R.id.huanjng_btn_fengxiang)
//    public void huanjng_btn_fengxiang() {
//        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS42".getBytes());
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
