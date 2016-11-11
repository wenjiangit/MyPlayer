package com.douliu.myplayer.base;

/**
 * Created by douliu on 2016/11/4.
 */
public interface BaseView<T> {
    void showError(Throwable e);

    void setPresenter(T t);
}
