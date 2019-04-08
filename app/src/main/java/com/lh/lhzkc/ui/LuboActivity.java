package com.lh.lhzkc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LuboActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lubo);

        ButterKnife.bind(this);


    }



    @OnClick(R.id.luzhi)
    public void luzhi() {
        HttpUtil.myPost("LUB1");
    }

    @OnClick(R.id.zanting)
    public void zanting() {
        HttpUtil.myPost("LUB2");
    }

    @OnClick(R.id.tingzhi)
    public void tingzhi() {
        HttpUtil.myPost("LUB3");
    }

    @OnClick(R.id.zhibo)
    public void zhibo() {
        HttpUtil.myPost("LUB4");
    }













}
