package com.lh.lhzkc.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;

import com.lh.lhzkc.MyApplication;
import com.lh.lhzkc.R;
import com.lh.lhzkc.utils.HttpUtil;
import com.lh.lhzkc.utils.MqttManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JuzhenActivity extends Activity {


    @BindView(R.id.spbtn_all_diannao)
    CheckBox spbtn_all_diannao;
    @BindView(R.id.spbtn_all_touping)
    CheckBox spbtn_all_touping;
    @BindView(R.id.spbtn_all_zu_1)
    CheckBox spbtn_all_zu_1;
    @BindView(R.id.spbtn_all_zu_2)
    CheckBox spbtn_all_zu_2;


    @BindView(R.id.spbtn_dan_in_lsdn)
    CheckBox spbtn_dan_in_lsdn;
    @BindView(R.id.spbtn_dan_in_tsj)
    CheckBox spbtn_dan_in_tsj;
    @BindView(R.id.spbtn_dan_in_bjb)
    CheckBox spbtn_dan_in_bjb;
    @BindView(R.id.spbtn_dan_in_gpy)
    CheckBox spbtn_dan_in_gpy;


    @BindView(R.id.spbtn_dan_out_ty)
    CheckBox spbtn_dan_out_ty;
    @BindView(R.id.spbtn_dan_out_dp1)
    CheckBox spbtn_dan_out_dp1;
    @BindView(R.id.spbtn_dan_out_dp2)
    CheckBox spbtn_dan_out_dp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juzhen);
        ButterKnife.bind(this);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @OnClick(R.id.spbtn_all_diannao)
    public void spbtn_all_diannao() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("VIDC1");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC1".getBytes());
        }
        spbtn_all_diannao.setChecked(true);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_touping)
    public void spbtn_all_touping() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("VIDC2");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC2".getBytes());
        }
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(true);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_zu_1)
    public void spbtn_all_zu_1() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("VIDC3");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC3".getBytes());
        }
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(true);
        spbtn_all_zu_2.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_zu_2)
    public void spbtn_all_zu_2() {
        if (MyApplication.prefs.getIsip()) {
            HttpUtil.myPost("VIDC4");
        } else {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC4".getBytes());
        }
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(true);
        danBtnClosed();
    }

    private void danBtnClosed() {
        spbtn_dan_in_lsdn.setChecked(false);
        spbtn_dan_in_tsj.setChecked(false);
        spbtn_dan_in_bjb.setChecked(false);
        spbtn_dan_in_gpy.setChecked(false);

        spbtn_dan_out_ty.setChecked(false);
        spbtn_dan_out_dp1.setChecked(false);
        spbtn_dan_out_dp2.setChecked(false);
    }

    @OnClick(R.id.spbtn_dan_in_lsdn)
    public void spbtn_dan_in_lsdn() {
        spbtn_dan_in_lsdn.setChecked(true);
        spbtn_dan_in_tsj.setChecked(false);
        spbtn_dan_in_bjb.setChecked(false);
        spbtn_dan_in_gpy.setChecked(false);

        spbtn_dan_out_ty.setChecked(false);
        spbtn_dan_out_dp1.setChecked(false);
        spbtn_dan_out_dp2.setChecked(false);
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_tsj)
    public void spbtn_dan_in_tsj() {
        spbtn_dan_in_lsdn.setChecked(false);
        spbtn_dan_in_tsj.setChecked(true);
        spbtn_dan_in_bjb.setChecked(false);
        spbtn_dan_in_gpy.setChecked(false);

        spbtn_dan_out_ty.setChecked(false);
        spbtn_dan_out_dp1.setChecked(false);
        spbtn_dan_out_dp2.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_bjb)
    public void spbtn_dan_in_bjb() {
        spbtn_dan_in_lsdn.setChecked(false);
        spbtn_dan_in_tsj.setChecked(false);
        spbtn_dan_in_bjb.setChecked(true);
        spbtn_dan_in_gpy.setChecked(false);

        spbtn_dan_out_ty.setChecked(false);
        spbtn_dan_out_dp1.setChecked(false);
        spbtn_dan_out_dp2.setChecked(false);
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_gpy)
    public void spbtn_dan_in_gpy() {
        spbtn_dan_in_lsdn.setChecked(false);
        spbtn_dan_in_tsj.setChecked(false);
        spbtn_dan_in_bjb.setChecked(false);
        spbtn_dan_in_gpy.setChecked(true);

        spbtn_dan_out_ty.setChecked(false);
        spbtn_dan_out_dp1.setChecked(false);
        spbtn_dan_out_dp2.setChecked(false);
        outBtnClosed();
    }

    private void outBtnClosed() {

    }

    @OnClick(R.id.spbtn_dan_out_ty)
    public void spbtn_dan_out_ty() {
        spbtn_dan_out_ty.setChecked(true);
        spbtn_dan_out_dp1.setChecked(false);
        spbtn_dan_out_dp2.setChecked(false);
        sendDan(1);
    }

    @OnClick(R.id.spbtn_dan_out_dp1)
    public void spbtn_dan_out_dp1() {
        spbtn_dan_out_ty.setChecked(true);
        spbtn_dan_out_dp1.setChecked(false);
        spbtn_dan_out_dp2.setChecked(false);
        sendDan(2);
    }

    @OnClick(R.id.spbtn_dan_out_dp2)
    public void spbtn_dan_out_dp2() {
        spbtn_dan_out_ty.setChecked(true);
        spbtn_dan_out_dp1.setChecked(false);
        spbtn_dan_out_dp2.setChecked(false);
        sendDan(3);
    }

    private void sendDan(int i) {
        if (MyApplication.prefs.getIsip()) {
            if (spbtn_dan_in_lsdn.isChecked()) {
                HttpUtil.myPost("VIDA1," + i);
            } else if (spbtn_dan_in_tsj.isChecked()) {
                HttpUtil.myPost("VIDA2," + i);
            } else if (spbtn_dan_in_bjb.isChecked()) {
                HttpUtil.myPost("VIDA3," + i);
            } else if (spbtn_dan_in_gpy.isChecked()) {
                HttpUtil.myPost("VIDA4," + i);
            }
        } else {
            if (spbtn_dan_in_lsdn.isChecked()) {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA1," + i).getBytes());
            } else if (spbtn_dan_in_tsj.isChecked()) {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA2," + i).getBytes());
            } else if (spbtn_dan_in_bjb.isChecked()) {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA3," + i).getBytes());
            } else if (spbtn_dan_in_gpy.isChecked()) {
                MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA4," + i).getBytes());
            }
        }
    }


}
