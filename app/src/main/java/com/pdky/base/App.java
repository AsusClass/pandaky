package com.pdky.base;

import android.app.Activity;
import android.app.Application;

import com.pdky.cache.SP;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by robot on 2017/5/16.
 */

public class App extends Application {


    private static App instance;    //Application实例


    private Set<Activity> allActivities;    //记录所有的activity

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SP.initialize(this,"config");
    }

    //单例获取application
    public static App getInstance() {
        return instance;
    }


    //记录每一个activiity实例，进行统一管理
    public void registerActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<Activity>();
        }
        allActivities.add(act);
    }

    //销毁activity记录
    public void unregisterActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }

    }

    //终结app，销毁每一个activity实例
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    if (act != null && !act.isFinishing())
                        act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


}
