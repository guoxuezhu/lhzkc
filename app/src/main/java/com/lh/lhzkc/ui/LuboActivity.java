package com.lh.lhzkc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LuboActivity extends Activity {

    @BindView(R.id.zhibo)
    CheckBox zhibo;


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
        if (zhibo.isChecked()) {
            HttpUtil.myPost("LUB4");
        } else {
            HttpUtil.myPost("LUB5");
        }
    }


}
