package com.douliu.myplayer.mvp.contract;

import com.douliu.myplayer.base.BasePresenter;
import com.douliu.myplayer.base.BaseView;
import com.douliu.myplayer.bean.VideoRes;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by wenjian on 2016/11/10.
 */
public class VideoInfoContract {

    public interface Presenter extends BasePresenter<View>{
        void getVideoDetail();
    }

    public interface View extends BaseView<Presenter>{
        JCVideoPlayerStandard getPlayer();

        void showContent(VideoRes videoRes);
    }
}
