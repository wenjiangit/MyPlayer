package com.douliu.myplayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.douliu.myplayer.app.App;
import com.douliu.myplayer.base.BaseActivity;
import com.douliu.myplayer.base.BasePresenter;
import com.douliu.myplayer.ui.adapter.MainPagerAdapter;
import com.douliu.myplayer.ui.fragments.ChosenFragment;
import com.douliu.myplayer.ui.fragments.DiscoverFragment;
import com.douliu.myplayer.ui.fragments.MineFragment;
import com.douliu.myplayer.ui.fragments.TopicFragment;
import com.douliu.myplayer.utils.EventUtil;
import com.douliu.myplayer.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.nav_view)
    NavigationView mNavView;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.view_pager)
    NoScrollViewPager mViewPager;
    @Bind(R.id.rb_tab1)
    RadioButton mRbTab1;
    @Bind(R.id.rb_tab2)
    RadioButton mRbTab2;
    @Bind(R.id.rb_tab3)
    RadioButton mRbTab3;
    @Bind(R.id.rb_tab4)
    RadioButton mRbTab4;
    @Bind(R.id.radio_group)
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        setTitle(R.string.mian_tab1);
        setupDrawlayout();
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), getFragments()));
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setScrollable(false);
        mViewPager.setCurrentItem(0);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    long lastTime;
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            long thisTime = System.currentTimeMillis();
            if (thisTime - lastTime > 1500){  //在1.5秒内连按两次回退键,退出程序
                EventUtil.showToast(this,R.string.back_to_exit);
                lastTime = thisTime;
            }else {
                App.getInstance().exitApp();
            }
        }
    }

    private void setupDrawlayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_collection:

                        break;
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @OnClick({R.id.rb_tab1, R.id.rb_tab2, R.id.rb_tab3, R.id.rb_tab4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_tab1:
                setSelection(0);
                break;
            case R.id.rb_tab2:
                setSelection(1);
                break;
            case R.id.rb_tab3:
                setSelection(2);
                break;
            case R.id.rb_tab4:
                setSelection(3);
                break;
        }
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        ChosenFragment chosenFragment = new ChosenFragment();
        fragments.add(chosenFragment);
        TopicFragment topicFragment = new TopicFragment();
        fragments.add(topicFragment);
        DiscoverFragment discoverFragment = new DiscoverFragment();
        fragments.add(discoverFragment);
        MineFragment mineFragment = new MineFragment();
        fragments.add(mineFragment);
        return fragments;
    }

    /**
     * 控制viewpager的展示页面
     *
     * @param position 从0开始
     */
    public void setSelection(int position) {
        mRadioGroup.clearCheck();
        switch (position) {
            case 0:
                mViewPager.setCurrentItem(0);
                mRbTab1.setChecked(true);
                setTitle(R.string.mian_tab1);
                break;
            case 1:
                mViewPager.setCurrentItem(1);
                mRbTab2.setChecked(true);
                setTitle(R.string.mian_tab2);
                break;
            case 2:
                mViewPager.setCurrentItem(2);
                mRbTab3.setChecked(true);
                setTitle(R.string.mian_tab3);
                break;
            case 3:
                mViewPager.setCurrentItem(3);
                mRbTab4.setChecked(true);
                setTitle(R.string.mian_tab4);
                break;
        }
    }


}
