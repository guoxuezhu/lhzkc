package com.lh.lhzkc.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import com.lh.lhzkc.R;
import com.lh.lhzkc.ui.base.BaseActivity;
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
                    ELog.i("========kahao=========" + kahao);
                    ic_kahao.setText(kahao.toString());
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

        startReadIC();
    }

    private void startReadIC() {
        DeviceMonitorService.flow().subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe((kahao) -> {
                    Message msg = new Message();
                    msg.obj = kahao.trim().toString();
                    msg.what = 1;
                    mHandler.sendMessage(msg);
                });

    }

    @Override
    protected void onDestroy() {
        mMainPresenter.detachView();//？
        DeviceMonitorService.stop();
        super.onDestroy();
    }

}
