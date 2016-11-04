package com.douliu.myplayer.base;

/**
 * Created by douliu on 2016/11/3.
 */
public interface BasePresenter<T> {
    void attachView(T view);

    void dettachView();
}
