package com.lh.lhzkc.ui.splash;

import com.lh.lhzkc.data.MvpClient;
import com.lh.lhzkc.ui.base.Presenter;

import javax.inject.Inject;

public class SplashPresenter implements Presenter<SplashMvpView> {

    private SplashMvpView sMvpView;
    private MvpClient mvpClient;

    @Inject
    public SplashPresenter(MvpClient client) {
        this.mvpClient = client;
    }

    @Override
    public void attachView(SplashMvpView mvpView) {
        sMvpView = mvpView;
    }

    @Override
    public void detachView() {
        sMvpView = null;
    }

}
