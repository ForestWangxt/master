package com.kpi.activity;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;


public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(this);

    }
}
