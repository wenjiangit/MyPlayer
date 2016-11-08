package com.douliu.myplayer.mvp.presenter;

import android.support.annotation.NonNull;

import com.douliu.myplayer.api.RetrofitHelper;
import com.douliu.myplayer.bean.Ret;
import com.douliu.myplayer.bean.VideoHttpResponse;
import com.douliu.myplayer.bean.VideoInfo;
import com.douliu.myplayer.mvp.contract.ChosenContract;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

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
                .subscribe(videoHttpResponse -> {
                    resoveResponse(videoHttpResponse);
                }, e -> mView.showError(e));
    }

    private void resoveResponse(VideoHttpResponse videoHttpResponse) {
        if (videoHttpResponse.getCode().equals("200")) {
            Ret ret = videoHttpResponse.getRet();
            List<VideoInfo> list = ret.getList();
            mView.showContent(list);
        }
    }

}
