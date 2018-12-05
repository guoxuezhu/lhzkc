package com.lh.lhzkc.ui.teacher;

import com.lh.lhzkc.data.MvpClient;
import com.lh.lhzkc.ui.base.Presenter;

import javax.inject.Inject;

public class TeacherPresenter implements Presenter<TeacherMvpView> {

    private TeacherMvpView tMvpView;
    private MvpClient mvpClient;

    @Inject
    public TeacherPresenter(MvpClient client) {
        this.mvpClient = client;
    }

    @Override
    public void attachView(TeacherMvpView mvpView) {
        tMvpView = mvpView;
    }

    @Override
    public void detachView() {
        tMvpView = null;
    }

}
