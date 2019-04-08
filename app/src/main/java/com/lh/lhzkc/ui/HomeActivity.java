package com.lh.lhzkc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends Activity {


    @BindView(R.id.zk_ip)
    EditText zk_ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        zk_ip.setText(MyApplication.prefs.getZKIP());
    }


    @OnClick(R.id.cj_btn_layout)
    public void cj_btn_layout() {
        startActivity(new Intent(this, ChangjingActivity.class));
        baocunIp();
    }

    private void baocunIp() {
        MyApplication.prefs.setZKIP(zk_ip.getText().toString());
    }


    @OnClick(R.id.sb_btn_layout)
    public void sb_btn_layout() {
        startActivity(new Intent(this, ShebeiActivity.class));
        baocunIp();
    }


    @OnClick(R.id.lb_btn_layout)
    public void lb_btn_layout() {
        startActivity(new Intent(this, LuboActivity.class));
        baocunIp();
    }


    @OnClick(R.id.jz_btn_layout)
    public void jz_btn_layout() {
        startActivity(new Intent(this, JuzhenActivity.class));
        baocunIp();
    }


    @OnClick(R.id.hj_btn_layout)
    public void hj_btn_layout() {
        startActivity(new Intent(this, HuanjingActivity.class));
        baocunIp();
    }


    @OnClick(R.id.yp_btn_layout)
    public void yp_btn_layout() {
        startActivity(new Intent(this, YinpinActivity.class));
        baocunIp();
    }


    @OnClick(R.id.dy_btn_layout)
    public void dy_btn_layout() {
        startActivity(new Intent(this, DianyuanActivity.class));
        baocunIp();
    }


}
