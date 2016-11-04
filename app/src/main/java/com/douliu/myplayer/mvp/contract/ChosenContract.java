package com.douliu.myplayer.mvp.contract;

import com.douliu.myplayer.base.BasePresenter;
import com.douliu.myplayer.base.BaseView;

/**
 * Created by douliu on 2016/11/4.
 */
public class ChosenContract {

    public interface Presenter extends BasePresenter<View>{

    }

    public interface View extends BaseView<Presenter>{

    }


}
