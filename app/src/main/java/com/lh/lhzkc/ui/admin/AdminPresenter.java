package com.lh.lhzkc.ui.admin;

import com.lh.lhzkc.data.MvpClient;
import com.lh.lhzkc.ui.base.Presenter;

import javax.inject.Inject;


public class AdminPresenter implements Presenter<AdminMvpView> {

    private static AdminMvpView aMvpView;
    private static MvpClient mvpClient;

    @Inject
    public AdminPresenter(MvpClient client) {
        this.mvpClient = client;
    }

    @Override
    public void attachView(AdminMvpView mvpView) {
        aMvpView = mvpView;
    }

    @Override
    public void detachView() {
        aMvpView = null;
    }


}
