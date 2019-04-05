package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DianyuanActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dianyuan);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.dy_all_open)
    public void dy_all_open() {
        HttpUtil.myPost("37");
    }

    @OnClick(R.id.dy_all_close)
    public void dy_all_close() {
        HttpUtil.myPost("38");
    }

}
