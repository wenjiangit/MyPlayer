package com.douliu.myplayer.mvp.presenter;

import android.support.annotation.NonNull;

import com.douliu.myplayer.mvp.contract.ChosenContract;

/**
 * Created by douliu on 2016/11/4.
 */
public class ChosenPresenter implements ChosenContract.Presenter{

    ChosenContract.View mView;

    @Override
    public void attachView(@NonNull ChosenContract.View view) {
        this.mView = view;
    }

    @Override
    public void dettachView() {
       this.mView = null;
    }
}
