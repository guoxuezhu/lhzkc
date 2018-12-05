package com.lh.lhzkc.ui.admin;

import android.os.Bundle;

import com.lh.lhzkc.R;
import com.lh.lhzkc.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class AdminActivity extends BaseActivity implements AdminMvpView {

    @Inject
    AdminPresenter mAdminPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);
        activityComponent().inject(this);
        mAdminPresenter.attachView(this);


    }

    @Override
    protected void onDestroy() {
        mAdminPresenter.detachView();//？
        super.onDestroy();
    }

}
