package com.douliu.myplayer.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 不能滑动的viewpager
 * Created by wenjian on 2016/11/4.
 */
public class NoScrollViewPager extends ViewPager{

    private boolean isScrollable = false;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isScrollable){
            return super.onTouchEvent(ev);
        }
        return false;//不消费onTouch事件
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isScrollable){
            return super.onInterceptTouchEvent(ev);
        }
        return false;//不拦截子控件的onTouch事件
    }

    public void setScrollable(boolean isScrollable){
        this.isScrollable = isScrollable;
    }
}
