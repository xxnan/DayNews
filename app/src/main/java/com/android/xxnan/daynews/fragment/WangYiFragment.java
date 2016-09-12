package com.android.xxnan.daynews.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.xxnan.daynews.IFragment.IWngYiFragment;
import com.android.xxnan.daynews.R;
import com.android.xxnan.daynews.adapter.WangYiRecycleAdapter;
import com.android.xxnan.daynews.bean.zhihu.wangyi.WangYiBean;
import com.android.xxnan.daynews.bean.zhihu.wangyi.WangYiNewsList;
import com.android.xxnan.daynews.implpersenter.ImplWangYiPersenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WangYiFragment extends BaseFragment implements IWngYiFragment {


    private RecyclerView newsRecyclerView;
    private ImplWangYiPersenter implWangYiPersenter;
    private IUpdateView iUpdateView;
    private WangYiRecycleAdapter wangYiRecycleAdapter;
    private ArrayList<WangYiBean> list =new ArrayList<>();
    public void setiUpdateView(IUpdateView iUpdateView) {
        this.iUpdateView = iUpdateView;
    }

    public WangYiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_wng_yi, null);
        newsRecyclerView = (RecyclerView) view.findViewById(R.id.news_recyclerView);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        wangYiRecycleAdapter=new WangYiRecycleAdapter(getActivity(),list);
        newsRecyclerView.setAdapter(wangYiRecycleAdapter);
        implWangYiPersenter = new ImplWangYiPersenter(getActivity(), this);
        implWangYiPersenter.getNewsList(0);
        return view;
    }

    @Override
    public void showProgressDialog() {
        iUpdateView.showProgress();
    }

    @Override
    public void hideProgressDialog() {
        iUpdateView.hideProgress();
    }

    @Override
    public void showErrorMessage(String error) {
        iUpdateView.showError(error);
    }


    @Override
    public void upDateNews(WangYiNewsList newsList) {
        list=newsList.getNewsList();
        wangYiRecycleAdapter.setList(list);
    }
}