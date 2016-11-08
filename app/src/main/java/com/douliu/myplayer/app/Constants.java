package com.douliu.myplayer.app;

import java.io.File;

/**
 * Created by douliu on 2016/11/8.
 */
public class Constants {
    //文件缓存根目录
    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + File.separator + "NetCache";
}
