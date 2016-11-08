package com.douliu.myplayer.mvp.contract;

import com.douliu.myplayer.base.BasePresenter;
import com.douliu.myplayer.base.BaseView;
import com.douliu.myplayer.bean.VideoHttpResponse;
import com.douliu.myplayer.bean.VideoInfo;

import java.util.List;

/**
 * Created by douliu on 2016/11/4.
 */
public class ChosenContract {

    public interface Presenter extends BasePresenter<View>{
        void getHomePageInfo();

    }

    public interface View extends BaseView<Presenter>{
        void showContent(List<VideoInfo> list);
    }


}
