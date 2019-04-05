package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangjingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changjing);

        ButterKnife.bind(this);


    }



    @OnClick(R.id.btn_shangke)
    public void btn_shangke() {
        HttpUtil.myPost("1");
    }

    @OnClick(R.id.btn_xiake)
    public void btn_xiake() {
        HttpUtil.myPost("2");
    }

    @OnClick(R.id.btn_zixi)
    public void btn_zixi() {
        HttpUtil.myPost("3");
    }

    @OnClick(R.id.btn_xiuxi)
    public void btn_xiuxi() {
        HttpUtil.myPost("4");
    }













}
