package com.lh.lhzkc.injection.component;

import android.app.Application;
import android.content.Context;

import com.lh.lhzkc.MvpApplication;
import com.lh.lhzkc.data.MvpClient;
import com.lh.lhzkc.data.db.AppDbModule;
import com.lh.lhzkc.injection.ApplicationContext;
import com.lh.lhzkc.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, AppDbModule.class})
public interface ApplicationComponent {

    void inject(MvpApplication mvpApplication);

    @ApplicationContext
    Context context();

    Application application();

    MvpClient mvpClient();


}
