package com.douliu.myplayer.mvp.presenter;

import android.support.annotation.NonNull;

import com.douliu.myplayer.api.RetrofitHelper;
import com.douliu.myplayer.bean.VideoHttpResponse;
import com.douliu.myplayer.bean.VideoRes;
import com.douliu.myplayer.bean.VideoType;
import com.douliu.myplayer.mvp.contract.ChosenContract;
import com.douliu.myplayer.utils.RxUtil;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by douliu on 2016/11/4.
 */
public class ChosenPresenter implements ChosenContract.Presenter {

    ChosenContract.View mView;

    public ChosenPresenter() {
    }

    @Override
    public void attachView(@NonNull ChosenContract.View view) {
        this.mView = view;
    }

    @Override
    public void dettachView() {
        this.mView = null;
    }


    @Override
    public void getHomePageInfo() {
        Subscription subscribe = RetrofitHelper.getVideoApi().getHomePage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxUtil.<VideoRes>handleResult())
                .subscribe(videoRes -> mView.showContent(videoRes.getList())
                        , e -> mView.showError(e));
    }

}
