package com.lh.lhzkc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
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


    @BindView(R.id.spbtn_all_lubo)
    CheckBox spbtn_all_lubo;
    @BindView(R.id.spbtn_all_diannao)
    CheckBox spbtn_all_diannao;
    @BindView(R.id.spbtn_all_touping)
    CheckBox spbtn_all_touping;
    @BindView(R.id.spbtn_all_zu_1)
    CheckBox spbtn_all_zu_1;
    @BindView(R.id.spbtn_all_zu_2)
    CheckBox spbtn_all_zu_2;
    @BindView(R.id.spbtn_all_zu_3)
    CheckBox spbtn_all_zu_3;
    @BindView(R.id.spbtn_all_zu_4)
    CheckBox spbtn_all_zu_4;
    @BindView(R.id.spbtn_all_zu_5)
    CheckBox spbtn_all_zu_5;
    @BindView(R.id.spbtn_all_zu_6)
    CheckBox spbtn_all_zu_6;


    @BindView(R.id.spbtn_dan_in_lubo)
    CheckBox spbtn_dan_in_lubo;
    @BindView(R.id.spbtn_dan_in_diannao)
    CheckBox spbtn_dan_in_diannao;
    @BindView(R.id.spbtn_dan_in_touping)
    CheckBox spbtn_dan_in_touping;
    @BindView(R.id.spbtn_dan_in_zu_1)
    CheckBox spbtn_dan_in_zu_1;
    @BindView(R.id.spbtn_dan_in_zu_2)
    CheckBox spbtn_dan_in_zu_2;
    @BindView(R.id.spbtn_dan_in_zu_3)
    CheckBox spbtn_dan_in_zu_3;
    @BindView(R.id.spbtn_dan_in_zu_4)
    CheckBox spbtn_dan_in_zu_4;
    @BindView(R.id.spbtn_dan_in_zu_5)
    CheckBox spbtn_dan_in_zu_5;
    @BindView(R.id.spbtn_dan_in_zu_6)
    CheckBox spbtn_dan_in_zu_6;


    @BindView(R.id.spbtn_dan_out_lubo)
    CheckBox spbtn_dan_out_lubo;
    @BindView(R.id.spbtn_dan_out_diannao)
    CheckBox spbtn_dan_out_diannao;
    @BindView(R.id.spbtn_dan_out_touping)
    CheckBox spbtn_dan_out_touping;
    @BindView(R.id.spbtn_dan_out_zu_1)
    CheckBox spbtn_dan_out_zu_1;
    @BindView(R.id.spbtn_dan_out_zu_2)
    CheckBox spbtn_dan_out_zu_2;
    @BindView(R.id.spbtn_dan_out_zu_3)
    CheckBox spbtn_dan_out_zu_3;
    @BindView(R.id.spbtn_dan_out_zu_4)
    CheckBox spbtn_dan_out_zu_4;
    @BindView(R.id.spbtn_dan_out_zu_5)
    CheckBox spbtn_dan_out_zu_5;
    @BindView(R.id.spbtn_dan_out_zu_6)
    CheckBox spbtn_dan_out_zu_6;


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

    @OnClick(R.id.spbtn_all_lubo)
    public void spbtn_all_lubo() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC8".getBytes());
        spbtn_all_lubo.setChecked(true);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_diannao)
    public void spbtn_all_diannao() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC9".getBytes());
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(true);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_touping)
    public void spbtn_all_touping() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC1".getBytes());
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(true);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_zu_1)
    public void spbtn_all_zu_1() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC2".getBytes());
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(true);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_zu_2)
    public void spbtn_all_zu_2() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC3".getBytes());
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(true);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_zu_3)
    public void spbtn_all_zu_3() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC4".getBytes());
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(true);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_zu_4)
    public void spbtn_all_zu_4() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC5".getBytes());
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(true);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_zu_5)
    public void spbtn_all_zu_5() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC6".getBytes());
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(true);
        spbtn_all_zu_6.setChecked(false);
        danBtnClosed();
    }

    @OnClick(R.id.spbtn_all_zu_6)
    public void spbtn_all_zu_6() {
        MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, "VIDC7".getBytes());
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(true);
        danBtnClosed();
    }

    private void danBtnClosed() {

        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);

        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);


    }


    @OnClick(R.id.spbtn_dan_in_lubo)
    public void spbtn_dan_in_lubo() {
        spbtn_dan_in_lubo.setChecked(true);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_diannao)
    public void spbtn_dan_in_diannao() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(true);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_touping)
    public void spbtn_dan_in_touping() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(true);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_zu_1)
    public void spbtn_dan_in_zu_1() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(true);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_zu_2)
    public void spbtn_dan_in_zu_2() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(true);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_zu_3)
    public void spbtn_dan_in_zu_3() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(true);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_zu_4)
    public void spbtn_dan_in_zu_4() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(true);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_zu_5)
    public void spbtn_dan_in_zu_5() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(true);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_zu_6)
    public void spbtn_dan_in_zu_6() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(true);
        outBtnClosed();
    }

    private void outBtnClosed() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
    }


    @OnClick(R.id.spbtn_dan_out_lubo)
    public void spbtn_dan_out_lubo() {
        spbtn_dan_out_lubo.setChecked(true);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(1);


    }

    @OnClick(R.id.spbtn_dan_out_diannao)
    public void spbtn_dan_out_diannao() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(true);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(2);
    }


    @OnClick(R.id.spbtn_dan_out_touping)
    public void spbtn_dan_out_touping() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(true);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(3);
    }

    @OnClick(R.id.spbtn_dan_out_zu_1)
    public void spbtn_dan_out_zu_1() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(true);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(4);
    }


    @OnClick(R.id.spbtn_dan_out_zu_2)
    public void spbtn_dan_out_zu_2() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(true);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(5);
    }

    @OnClick(R.id.spbtn_dan_out_zu_3)
    public void spbtn_dan_out_zu_3() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(true);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(6);
    }


    @OnClick(R.id.spbtn_dan_out_zu_4)
    public void spbtn_dan_out_zu_4() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(true);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(7);
    }


    @OnClick(R.id.spbtn_dan_out_zu_5)
    public void spbtn_dan_out_zu_5() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(true);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(8);
    }


    @OnClick(R.id.spbtn_dan_out_zu_6)
    public void spbtn_dan_out_zu_6() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(true);

        sendDan(9);
    }

    private void sendDan(int i) {
        if (spbtn_dan_in_lubo.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA8," + i).getBytes());
        } else if (spbtn_dan_in_diannao.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA9," + i).getBytes());
        } else if (spbtn_dan_in_touping.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA1," + i).getBytes());
        } else if (spbtn_dan_in_zu_1.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA2," + i).getBytes());
        } else if (spbtn_dan_in_zu_2.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA3," + i).getBytes());
        } else if (spbtn_dan_in_zu_3.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA4," + i).getBytes());
        } else if (spbtn_dan_in_zu_4.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA5," + i).getBytes());
        } else if (spbtn_dan_in_zu_5.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA6," + i).getBytes());
        } else if (spbtn_dan_in_zu_6.isChecked()) {
            MqttManager.getInstance().publish(MyApplication.prefs.getzkname(), 0, ("VIDA7," + i).getBytes());
        }
    }


}
