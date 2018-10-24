package com.lh.lhzkc.ui.main;

import android.os.Bundle;

import com.lh.lhzkc.R;
import com.lh.lhzkc.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activityComponent().inject(this);
        mMainPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        mMainPresenter.detachView();//？
        super.onDestroy();
    }

}
