package com.lh.lhzkc.injection.component;

import com.lh.lhzkc.injection.PerActivity;
import com.lh.lhzkc.injection.module.ActivityModule;
import com.lh.lhzkc.ui.main.MainActivity;
import com.lh.lhzkc.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);
}

