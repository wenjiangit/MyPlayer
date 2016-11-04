package com.douliu.myplayer.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.douliu.myplayer.R;
import com.douliu.myplayer.base.BaseFragment;
import com.douliu.myplayer.base.BasePresenter;
import com.douliu.myplayer.mvp.contract.ChosenContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChosenFragment extends BaseFragment<ChosenContract.Presenter> implements ChosenContract.View {


    public ChosenFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_chosen;
    }

    @Override
    public ChosenContract.Presenter createPresenter() {
        return null;
    }


    @Override
    public void setPresenter(ChosenContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
