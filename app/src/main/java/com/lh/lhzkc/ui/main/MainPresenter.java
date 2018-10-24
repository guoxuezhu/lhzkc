package com.lh.lhzkc.ui.main;

import com.lh.lhzkc.data.MvpClient;
import com.lh.lhzkc.ui.base.Presenter;

import javax.inject.Inject;


public class MainPresenter implements Presenter<MainMvpView> {

    private static MainMvpView mMvpView;
    private static MvpClient mvpClient;

    @Inject
    public MainPresenter(MvpClient client) {
        this.mvpClient = client;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }



}
