package com.douliu.myplayer.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.douliu.myplayer.R;
import com.douliu.myplayer.base.BaseActivity;
import com.douliu.myplayer.base.BasePresenter;
import com.douliu.myplayer.bean.VideoInfo;
import com.douliu.myplayer.mvp.presenter.VideoInfoPresenter;
import com.douliu.myplayer.ui.fragments.VideoInfoFragment;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoInfoActivity extends BaseActivity {

    public static final String PARAM_INFO = "PARAM_INFO";

    private VideoInfo mVideoInfo;

    public static void starter(Context ctx, VideoInfo videoInfo){
        Intent intent = new Intent(ctx,VideoInfoActivity.class);
        intent.putExtra(PARAM_INFO,videoInfo);
        ctx.startActivity(intent);
    }

    @Override
    protected void init() {
        mVideoInfo = (VideoInfo) getIntent().getSerializableExtra(PARAM_INFO);
        setTitle(mVideoInfo.getTitle());
        VideoInfoFragment fragment = (VideoInfoFragment) getSupportFragmentManager().findFragmentById(R.id.fl_content);
        if (fragment == null){
            fragment = new VideoInfoFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_content,fragment).commit();
        }
        new VideoInfoPresenter(fragment,mVideoInfo);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.second_level;
    }

    @Override
    protected boolean canBack() {
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
}
