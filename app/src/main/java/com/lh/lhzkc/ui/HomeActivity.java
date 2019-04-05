package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.lh.lhzkc.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
    }



    @OnClick(R.id.cj_btn_layout)
    public void cj_btn_layout() {
        startActivity(new Intent(this, ChangjingActivity.class));
        finish();
    }


    @OnClick(R.id.sb_btn_layout)
    public void sb_btn_layout() {
        startActivity(new Intent(this, ShebeiActivity.class));
        finish();
    }


    @OnClick(R.id.lb_btn_layout)
    public void lb_btn_layout() {
        startActivity(new Intent(this, LuboActivity.class));
        finish();
    }


    @OnClick(R.id.jz_btn_layout)
    public void jz_btn_layout() {
        startActivity(new Intent(this, JuzhenActivity.class));
        finish();
    }


    @OnClick(R.id.hj_btn_layout)
    public void hj_btn_layout() {
        startActivity(new Intent(this, HuanjingActivity.class));
        finish();
    }


    @OnClick(R.id.yp_btn_layout)
    public void yp_btn_layout() {
        startActivity(new Intent(this, YinpinActivity.class));
        finish();
    }


    @OnClick(R.id.dy_btn_layout)
    public void dy_btn_layout() {
        startActivity(new Intent(this, DianyuanActivity.class));
        finish();
    }



















}
