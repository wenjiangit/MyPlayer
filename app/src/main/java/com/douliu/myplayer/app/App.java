package com.douliu.myplayer.app;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

import java.util.HashSet;

/**
 * 程序启动的入口
 * Created by wenjian on 2016/11/3.
 */
public class App extends Application{
    public static App instance;

    public static HashSet<Activity> mActivtySet;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance(){
        return instance;
    }

    public void registActivity(Activity activity){
        if (mActivtySet == null){
            mActivtySet = new HashSet<>();
        }
        mActivtySet.add(activity);
    }

    public void unregistActivity(Activity activity){
        if (mActivtySet != null){
            mActivtySet.remove(activity);
        }
    }

    /**
     * 退出当前应用
     */
    public void exitApp(){
        if (mActivtySet != null){
            synchronized (App.class){
                for (Activity activity:mActivtySet){
                    if (activity!= null || !activity.isFinishing()){
                        activity.finish();
                    }
                }
            }
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
