package com.douliu.myplayer.ui.fragments;


import android.text.TextUtils;
import android.view.View;

import com.douliu.myplayer.R;
import com.douliu.myplayer.base.BaseFragment;
import com.douliu.myplayer.bean.VideoRes;
import com.douliu.myplayer.mvp.contract.VideoInfoContract;
import com.douliu.myplayer.utils.EventUtil;
import com.douliu.myplayer.utils.ImageLoader;

import butterknife.Bind;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class VideoInfoFragment extends BaseFragment<VideoInfoContract.Presenter> implements VideoInfoContract.View {

    @Bind(R.id.video_player)
    JCVideoPlayerStandard mVideoPlayer;

    public VideoInfoFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View rootView) {
        mPresenter.getVideoDetail();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_video_info;
    }

    @Override
    public VideoInfoContract.Presenter createPresenter() {
        return null;
    }

    @Override
    public void showError(Throwable e) {
        e.printStackTrace();
        EventUtil.showToast(getContext(),e.toString());
    }

    @Override
    public void setPresenter(VideoInfoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public JCVideoPlayerStandard getPlayer() {
        return mVideoPlayer;
    }

    @Override
    public void showContent(VideoRes videoRes) {
        if (!TextUtils.isEmpty(videoRes.getVideoUrl())){
            mVideoPlayer.setUp(videoRes.getVideoUrl(),JCVideoPlayer.SCREEN_LAYOUT_LIST,videoRes.getTitle());
        }
        if (!TextUtils.isEmpty(videoRes.getPic())){
            ImageLoader.display(getContext(),videoRes.getPic(),mVideoPlayer.thumbImageView);
        }

    }

}
