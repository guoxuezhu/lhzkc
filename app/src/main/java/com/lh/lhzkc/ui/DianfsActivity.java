package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DianfsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dianfs);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.dfs_btn_close)
    public void dfs_btn_close() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS8001");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS8001".getBytes());
        }
    }

    @OnClick(R.id.dfs_btn_fs_1)
    public void dfs_btn_fs_1() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS8002");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS8002".getBytes());
        }
    }

    @OnClick(R.id.dfs_btn_fs_2)
    public void dfs_btn_fs_2() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS8003");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS8003".getBytes());
        }
    }

    @OnClick(R.id.dfs_btn_fs_3)
    public void dfs_btn_fs_3() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("MBS8004");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "MBS8004".getBytes());
        }
    }


}