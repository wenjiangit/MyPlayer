package com.douliu.myplayer.mvp.presenter;

import com.douliu.myplayer.api.RetrofitHelper;
import com.douliu.myplayer.bean.VideoHttpResponse;
import com.douliu.myplayer.bean.VideoInfo;
import com.douliu.myplayer.bean.VideoRes;
import com.douliu.myplayer.mvp.contract.VideoInfoContract;
import com.douliu.myplayer.utils.ImageLoader;
import com.douliu.myplayer.utils.RxUtil;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by douliu on 2016/11/10.
 */
public class VideoInfoPresenter implements VideoInfoContract.Presenter{

    private VideoInfoContract.View mView;

    private VideoInfo mVideoInfo;

    public VideoInfoPresenter(VideoInfoContract.View view, VideoInfo videoInfo) {
        mView = view;
        mVideoInfo = videoInfo;
        mView.setPresenter(this);
    }

    @Override
    public void attachView(VideoInfoContract.View view) {
    }

    @Override
    public void dettachView() {
        mView = null;
    }

    @Override
    public void getVideoDetail() {
        RetrofitHelper.getVideoApi().getVideoDetail(mVideoInfo.getDataId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxUtil.handleResult())
                .subscribe(videoRes -> {
                    mView.showContent(videoRes);
                }, throwable -> {
                    mView.showError(throwable);
                });
    }


}
