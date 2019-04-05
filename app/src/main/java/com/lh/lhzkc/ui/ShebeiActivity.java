package com.lh.lhzkc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShebeiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shebei);

        ButterKnife.bind(this);
    }


    @OnClick(R.id.rbtn_cl_1_open)
    public void rbtn_cl_1_open() {
        HttpUtil.myPost("5");
    }


    @OnClick(R.id.rbtn_cl_1_close)
    public void rbtn_cl_1_close() {
        HttpUtil.myPost("6");
    }


    @OnClick(R.id.rbtn_cl_2_open)
    public void rbtn_cl_2_open() {
        HttpUtil.myPost("7");
    }

    @OnClick(R.id.rbtn_cl_2_close)
    public void rbtn_cl_2_close() {
        HttpUtil.myPost("8");

    }


    @OnClick(R.id.rbtn_tyj_open)
    public void rbtn_tyj_open() {
        HttpUtil.myPost("9");

    }

    @OnClick(R.id.rbtn_tyj_close)
    public void rbtn_tyj_close() {
        HttpUtil.myPost("10");

    }


    @OnClick(R.id.rbtn_tyj_bu_open)
    public void rbtn_tyj_bu_open() {
        HttpUtil.myPost("11");
    }

    @OnClick(R.id.rbtn_tyj_bu_close)
    public void rbtn_tyj_bu_close() {
        HttpUtil.myPost("12");
    }


    @OnClick(R.id.rbtn_dg_1_open)
    public void rbtn_dg_1_open() {
        HttpUtil.myPost("13");
    }

    @OnClick(R.id.rbtn_dg_1_close)
    public void rbtn_dg_1_close() {
        HttpUtil.myPost("14");
    }

    @OnClick(R.id.rbtn_dg_2_open)
    public void rbtn_dg_2_open() {
        HttpUtil.myPost("15");
    }

    @OnClick(R.id.rbtn_dg_2_close)
    public void rbtn_dg_2_close() {
        HttpUtil.myPost("16");
    }


    @OnClick(R.id.rbtn_dg_3_open)
    public void rbtn_dg_3_open() {
        HttpUtil.myPost("17");

    }

    @OnClick(R.id.rbtn_dg_3_close)
    public void rbtn_dg_3_close() {
        HttpUtil.myPost("18");
    }


    @OnClick(R.id.rbtn_dg_4_open)
    public void rbtn_dg_4_open() {
        HttpUtil.myPost("19");
    }

    @OnClick(R.id.rbtn_dg_4_close)
    public void rbtn_dg_4_close() {
        HttpUtil.myPost("20");
    }

    @OnClick(R.id.btn_qianmen_open)
    public void btn_qianmen_open() {
        //HttpUtil.myPost("20");
    }

    @OnClick(R.id.btn_houmen_open)
    public void btn_houmen_open() {
        //HttpUtil.myPost("20");
    }
}
