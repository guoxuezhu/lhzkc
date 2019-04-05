package com.lh.lhzkc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YinpinActivity extends Activity {


    @BindView(R.id.zyl_jingyin)
    CheckBox zyl_jingyin;
    @BindView(R.id.yx_jingyin)
    CheckBox yx_jingyin;
    @BindView(R.id.mkf_jingyin)
    CheckBox mkf_jingyin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yinpin);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.zyl_jia)
    public void zyl_jia() {
        HttpUtil.myPost("21");
    }

    @OnClick(R.id.zyl_jian)
    public void zyl_jian() {
        HttpUtil.myPost("22");
    }

    @OnClick(R.id.zyl_jingyin)
    public void zyl_jingyin() {
        if (zyl_jingyin.isChecked()) {
            HttpUtil.myPost("23");
        } else {
            HttpUtil.myPost("24");
        }
    }


    @OnClick(R.id.yx_jia)
    public void yx_jia() {
        HttpUtil.myPost("25");
    }


    @OnClick(R.id.yx_jian)
    public void yx_jian() {
        HttpUtil.myPost("26");
    }

    @OnClick(R.id.yx_jingyin)
    public void yx_jingyin() {
        if (yx_jingyin.isChecked()) {
            HttpUtil.myPost("27");
        } else {
            HttpUtil.myPost("28");
        }
    }

    @OnClick(R.id.mkf_jia)
    public void mkf_jia() {
        HttpUtil.myPost("29");
    }


    @OnClick(R.id.mkf_jian)
    public void mkf_jian() {
        HttpUtil.myPost("30");
    }

    @OnClick(R.id.mkf_jingyin)
    public void mkf_jingyin() {
        if (mkf_jingyin.isChecked()) {
            HttpUtil.myPost("31");
        } else {
            HttpUtil.myPost("32");
        }
    }


}
