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

    @OnClick(R.id.spbtn_all_lubo)
    public void spbtn_all_lubo() {
        HttpUtil.myPost("VIDC1");
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
        HttpUtil.myPost("VIDC2");
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
        HttpUtil.myPost("VIDC3");
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
        HttpUtil.myPost("VIDC4");
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
        HttpUtil.myPost("VIDC5");
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
        HttpUtil.myPost("VIDC6");
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
        HttpUtil.myPost("VIDC7");
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
        HttpUtil.myPost("VIDC8");
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
        HttpUtil.myPost("VIDC9");
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
    public void spbtn_out_in_lubo() {
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
            HttpUtil.myPost("VIDA1," + i);
        } else if (spbtn_dan_in_diannao.isChecked()) {
            HttpUtil.myPost("VIDA2," + i);
        } else if (spbtn_dan_in_touping.isChecked()) {
            HttpUtil.myPost("VIDA3," + i);
        } else if (spbtn_dan_in_zu_1.isChecked()) {
            HttpUtil.myPost("VIDA4," + i);
        } else if (spbtn_dan_in_zu_2.isChecked()) {
            HttpUtil.myPost("VIDA5," + i);
        } else if (spbtn_dan_in_zu_3.isChecked()) {
            HttpUtil.myPost("VIDA6," + i);
        } else if (spbtn_dan_in_zu_4.isChecked()) {
            HttpUtil.myPost("VIDA7," + i);
        } else if (spbtn_dan_in_zu_5.isChecked()) {
            HttpUtil.myPost("VIDA8," + i);
        } else if (spbtn_dan_in_zu_6.isChecked()) {
            HttpUtil.myPost("VIDA9," + i);
        }
    }


}
