package com.douliu.myplayer.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.douliu.myplayer.app.App;

/**
 * Created by douliu on 2016/11/8.
 */
public class SystemUtils {

    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }


}
