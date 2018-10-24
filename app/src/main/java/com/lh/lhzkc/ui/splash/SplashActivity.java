package com.lh.lhzkc.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.lh.lhzkc.R;
import com.lh.lhzkc.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;


public class SplashActivity extends BaseActivity implements SplashMvpView {

    @Inject
    SplashPresenter mSplashPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        activityComponent().inject(this);
        mSplashPresenter.attachView(this);

    }


    @Override
    protected void onDestroy() {
        mSplashPresenter.detachView();//？
        super.onDestroy();
    }

}
