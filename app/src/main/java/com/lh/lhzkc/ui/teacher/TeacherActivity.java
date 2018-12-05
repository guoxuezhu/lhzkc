package com.lh.lhzkc.ui.teacher;

import android.os.Bundle;

import com.lh.lhzkc.R;
import com.lh.lhzkc.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class TeacherActivity extends BaseActivity implements TeacherMvpView {

    @Inject
    TeacherPresenter mTeacherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        ButterKnife.bind(this);
        activityComponent().inject(this);
        mTeacherPresenter.attachView(this);




    }



    @Override
    protected void onDestroy() {
        mTeacherPresenter.detachView();//？
        super.onDestroy();
    }

}
