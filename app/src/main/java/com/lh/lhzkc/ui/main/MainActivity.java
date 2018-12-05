package com.lh.lhzkc.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.lh.lhzkc.R;
import com.lh.lhzkc.ui.admin.AdminActivity;
import com.lh.lhzkc.ui.base.BaseActivity;
import com.lh.lhzkc.ui.teacher.TeacherActivity;
import com.lh.lhzkc.utils.ELog;

import javax.inject.Inject;

import android_serialport_api.DeviceMonitorService;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements MainMvpView {

    @BindView(R.id.ic_kahao)
    TextView ic_kahao;


    @Inject
    MainPresenter mMainPresenter;


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String kahao = msg.obj.toString();
                    ic_kahao.setText(kahao);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activityComponent().inject(this);
        mMainPresenter.attachView(this);


        DeviceMonitorService.flow().subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe((kahao) -> {
                    ELog.i("========kahao=========" + kahao);
                    ReadIC(kahao);
                    Message msg = new Message();
                    msg.obj = kahao.trim();
                    msg.what = 1;
                    mHandler.sendMessage(msg);
                });

    }

    private void ReadIC(String kahao) {
        if (kahao.equals("2847172473")) {
            startActivity(new Intent(this, AdminActivity.class));
        } else if (kahao.equals("2868067108")) {
            startActivity(new Intent(this, TeacherActivity.class));
        }
        finish();

    }

    @Override
    protected void onDestroy() {
        mMainPresenter.detachView();//？
        DeviceMonitorService.stop();
        super.onDestroy();
    }

}
