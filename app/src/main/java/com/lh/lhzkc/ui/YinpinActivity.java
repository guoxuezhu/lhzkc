package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.SeekBar;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.ELog;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YinpinActivity extends Activity {

    @BindView(R.id.yp_scht)
    RadioButton yp_scht;
    @BindView(R.id.yp_tdht)
    RadioButton yp_tdht;
    @BindView(R.id.yp_kjyl)
    RadioButton yp_kjyl;
    @BindView(R.id.yp_hxht)
    RadioButton yp_hxht;

    @BindView(R.id.seek_bar_yl)
    SeekBar seek_bar_yl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yinpin);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        yp_scht.setChecked(true);
        seek_bar_yl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ELog.i("===========SeekBar=====onStopTrackingTouch=======" + seekBar.getProgress());
                int yl = 22 - seekBar.getProgress();
                String ylstr;
                if (yl < 10) {
                    ylstr = "0" + yl;
                } else {
                    ylstr = "" + yl;
                }
                String sendmsg = "";
                if (yl == 22) {
                    ylstr = "JY";
                }
                if (yp_scht.isChecked()) {
                    sendmsg = "MICA" + ylstr;
                } else if (yp_tdht.isChecked()) {
                    sendmsg = "MICB" + ylstr;
                } else if (yp_kjyl.isChecked()) {
                    sendmsg = "MICC" + ylstr;
                } else if (yp_hxht.isChecked()) {
                    sendmsg = "MICD" + ylstr;
                }
                if (MyApplication.prefs.getIsip()) {
                    HttpUtil.myPost(sendmsg);
                } else {
                    MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, sendmsg.getBytes());
                }
            }
        });
    }


}