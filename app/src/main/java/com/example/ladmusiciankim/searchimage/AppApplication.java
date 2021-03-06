package com.example.ladmusiciankim.searchimage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

public class AppApplication extends Application implements Application.ActivityLifecycleCallbacks {
    @SuppressLint("StaticFieldLeak")
    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
