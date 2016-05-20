package com.kpi.activity;

import android.app.Activity;
import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

import java.util.LinkedList;


public class MyApp extends Application {

    private LinkedList<Activity> activitys = null;
    private static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(this);

    }

    public MyApp() {
        activitys = new LinkedList<>();
    }

    public static MyApp getInstance() {
        if (null == instance) {
            instance = new MyApp();
        }
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        if (activitys != null && activitys.size() > 0) {
            if (!activitys.contains(activity)) {
                activitys.add(activity);
            }
        } else {
            activitys.add(activity);
        }
    }

    // 遍历所有Activity并finish
    public void exit() {
        if (activitys != null && activitys.size() > 0) {
            for (Activity activity : activitys) {
                activity.finish();
            }
        }
    }
}
