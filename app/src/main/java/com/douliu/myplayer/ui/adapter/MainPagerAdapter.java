package com.douliu.myplayer.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by douliu on 2016/11/4.
 */
public class MainPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> mFragments;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mFragments = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
