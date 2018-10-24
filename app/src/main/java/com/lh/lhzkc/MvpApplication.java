package com.lh.lhzkc;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.lh.lhzkc.data.db.SharePreferenceUtil;
import com.lh.lhzkc.injection.component.ApplicationComponent;
import com.lh.lhzkc.injection.component.DaggerApplicationComponent;
import com.lh.lhzkc.injection.module.ApplicationModule;

/**
 * Created by gxz
 */
public class MvpApplication extends MultiDexApplication {
    private ApplicationComponent mApplicationComponent;

    public static MvpApplication get(Context context) {
        return (MvpApplication) context.getApplicationContext();
    }

    public static SharePreferenceUtil prefs;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        setupComponent();
        prefs = new SharePreferenceUtil(this, "zkcSaveDates");
    }

    private void setupComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


}
