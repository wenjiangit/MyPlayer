package com.douliu.myplayer.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by douliu on 2016/11/4.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment{

    protected final String TAG = getClass().getSimpleName();

    protected View mRootView;

    protected T mPresenter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        mPresenter.attachView(this);
        if (mRootView == null){
            mRootView = inflater.inflate(getLayout(),container,false);
        }
        ButterKnife.bind(this,mRootView);
        initView(mRootView);
        return mRootView;
    }

    protected abstract void initView(View rootView);

    public abstract int getLayout();

    public abstract T createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dettachView();
        mPresenter = null;
    }
}
