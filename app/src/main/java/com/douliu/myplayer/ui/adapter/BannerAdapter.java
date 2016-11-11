package com.douliu.myplayer.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.douliu.myplayer.bean.VideoInfo;
import com.douliu.myplayer.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Banner图的适配器
 * Created by wenjian on 2016/11/8.
 */
public class BannerAdapter extends PagerAdapter{

    private List<VideoInfo> mVideoInfos;

    private static List<ImageView> mImageList = new ArrayList<>();

    private Context mContext;

    public BannerAdapter(Context ctx,List<VideoInfo> list) {
        mVideoInfos = list;
        mContext = ctx;
        initImageList();
    }

    private void initImageList() {
        for (int i = 0; i < mVideoInfos.size();i++){
            ImageView imageView = new ImageView(mContext);
            mImageList.add(imageView);
        }
    }

    public void setData(List<VideoInfo> list){
        mVideoInfos = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int pos = position % mVideoInfos.size();
        ImageView imageView = mImageList.get(pos);
        ImageLoader.display(container.getContext(),mVideoInfos.get(pos).getPic(),imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImageList.get(position% mVideoInfos.size()));
    }
}
