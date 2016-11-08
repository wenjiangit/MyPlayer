package com.douliu.myplayer.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.douliu.myplayer.R;
import com.douliu.myplayer.base.BaseFragment;
import com.douliu.myplayer.bean.VideoInfo;
import com.douliu.myplayer.mvp.contract.ChosenContract;
import com.douliu.myplayer.mvp.presenter.ChosenPresenter;
import com.douliu.myplayer.ui.adapter.ChosenAdapter;
import com.douliu.myplayer.utils.EventUtil;
import com.douliu.myplayer.utils.L;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChosenFragment extends BaseFragment<ChosenContract.Presenter> implements ChosenContract.View,
        SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    private ChosenAdapter mChosenAdapter;

    public ChosenFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View rootView) {
        setupRefreshLayout();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mChosenAdapter = new ChosenAdapter(getContext()));
        mRefreshLayout.setRefreshing(true);
        mPresenter.getHomePageInfo();
    }

    private void setupRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(R.color.colorRedPrimary,R.color.colorOrangePrimary,R.color.colorBluePrimary);
        mRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_chosen;
    }

    @Override
    public ChosenContract.Presenter createPresenter() {
        return new ChosenPresenter();
    }

    @Override
    public void setPresenter(ChosenContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {
        EventUtil.showToast(getContext(), e.toString());
        e.printStackTrace();
    }

    @Override
    public void showContent(List<VideoInfo> list) {
        L.d(this.getClass(), "请求结果:" + list);
        if (list != null && list.size() > 0){
            for (int i = 1;i < list.size();i++){
                mChosenAdapter.addAll(list.get(i).getChildList());
            }
        }
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        mPresenter.getHomePageInfo();
    }
}
