package com.douliu.myplayer.ui.fragments;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.douliu.myplayer.R;
import com.douliu.myplayer.base.BaseFragment;
import com.douliu.myplayer.bean.VideoInfo;
import com.douliu.myplayer.bean.VideoType;
import com.douliu.myplayer.mvp.contract.ChosenContract;
import com.douliu.myplayer.mvp.presenter.ChosenPresenter;
import com.douliu.myplayer.ui.adapter.ChosenAdapter;
import com.douliu.myplayer.utils.EventUtil;
import com.douliu.myplayer.utils.L;
import com.douliu.myplayer.widget.Banner;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.Bind;

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
    private Banner mBanner;
    private List<VideoType> mTypeList;

    public ChosenFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View rootView) {
        setupRefreshLayout();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mChosenAdapter = new ChosenAdapter(getContext()));
        mChosenAdapter.addHeader(new BannerView());
        mRefreshLayout.setRefreshing(true);
        mPresenter.getHomePageInfo();
    }

    private void setupRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(R.color.colorRedPrimary, R.color.colorOrangePrimary, R.color.colorGreenPrimary);
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
    public void showError(Throwable e) {
        e.printStackTrace();
        EventUtil.showToast(getContext(), R.string.erro_msg);
    }

    @Override
    public void showContent(List<VideoInfo> list) {
        L.d(this.getClass(), "请求结果:" + list);
        mChosenAdapter.clear();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    mTypeList = list.get(i).getChildList();
                    mBanner.init(mTypeList, item -> {
                    });
                    mBanner.startAutoRun();
                } else {
                    mChosenAdapter.addAll(list.get(i).getChildList());
                }
            }
        }
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        mPresenter.getHomePageInfo();
    }

    class BannerView implements RecyclerArrayAdapter.ItemView {
        @Override
        public View onCreateView(ViewGroup parent) {
            return View.inflate(parent.getContext(), R.layout.banner_item, null);
        }

        @Override
        public void onBindView(View headerView) {
            mBanner = (Banner) headerView.findViewById(R.id.view_pager);
        }
    }

}
