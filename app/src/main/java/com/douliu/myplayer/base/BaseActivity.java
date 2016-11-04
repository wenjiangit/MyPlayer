package com.douliu.myplayer.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.douliu.myplayer.R;
import com.douliu.myplayer.app.App;

import butterknife.ButterKnife;


/**
 * Created by wenjian on 2016/11/3.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected Toolbar mToolbar;

    private ActionBar mActionBar;

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        App.getInstance().registActivity(this);

        setupToolbar();
        init();
        //不一定都要实现mvp模式
        if (createPresenter() != null){
            mPresenter = createPresenter();
        }
    }

    protected abstract void init();

    protected abstract T createPresenter();

    private void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null){
            setSupportActionBar(mToolbar);
            mActionBar = getSupportActionBar();
            if (canBack()){
                mActionBar.setDefaultDisplayHomeAsUpEnabled(true);
            }else {
                mActionBar.setDisplayHomeAsUpEnabled(true);
                mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
//                mActionBar.setDisplayShowHomeEnabled(true);
            }
            if (Build.VERSION.SDK_INT >= 21){
                mActionBar.setElevation(10.6f);//z轴浮动
            }
        }
    }

    public abstract int getLayout();

    protected boolean canBack() {
        return false;
    }

    public void setTitle(String text){
        if (mActionBar!= null){
            mActionBar.setTitle(text);
        }
    }

    public void setTitle(int resId){
        if (mActionBar != null){
            mActionBar.setTitle(getResources().getString(resId));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().unregistActivity(this);
    }
}
