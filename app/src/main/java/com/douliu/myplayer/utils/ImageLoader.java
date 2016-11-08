package com.douliu.myplayer.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 图片加载工具
 * Created by wenjian on 2016/11/8.
 */
public class ImageLoader {

    public static void display(Context ctx, String url, ImageView iv){
        Glide.with(ctx).load(url).into(iv);
    }
}
