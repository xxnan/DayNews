package com.android.xxnan.daynews.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.xxnan.daynews.IFragment.IZhiHuFragment;
import com.android.xxnan.daynews.R;
import com.android.xxnan.daynews.adapter.ZhiHuRecycleAdapter;
import com.android.xxnan.daynews.bean.zhihu.ZhiHuBean;
import com.android.xxnan.daynews.bean.zhihu.ZhiHuStories;
import com.android.xxnan.daynews.implpersenter.ImplZhiHuPersenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiHuFragment extends BaseFragment implements IZhiHuFragment{


    private RecyclerView recyclerView;
    private ZhiHuBean zhiHuBean;
    private ArrayList<ZhiHuStories> stories;
    private ZhiHuRecycleAdapter zhihuAdapter;
    private ImplZhiHuPersenter implZhiHuPersenter;
    private IUpdateView iUpdateView;

    public void setiUpdateView(IUpdateView iUpdateView) {
        this.iUpdateView = iUpdateView;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 0x110) {
                zhiHuBean = (ZhiHuBean) msg.obj;
                stories = zhiHuBean.getStories();
                zhihuAdapter.setData(stories);
            }
        }
    };
    public ZhiHuFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_zhi_hu, container, false);
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        zhiHuBean = new ZhiHuBean();
        stories = new ArrayList<ZhiHuStories>();
        implZhiHuPersenter = new ImplZhiHuPersenter(getActivity(), this);
        implZhiHuPersenter.getLastZhihuNews();

        zhihuAdapter = new ZhiHuRecycleAdapter(getActivity(), stories);
        recyclerView.setAdapter(zhihuAdapter);
        return view;
    }

    @Override
    public void updateList(ZhiHuBean zhiHuBean) {
        Message msg = handler.obtainMessage();
        msg.arg1 = 0x110;
        msg.obj = zhiHuBean;
        handler.sendMessage(msg);
    }

    @Override
    public void showProgressDialog() {
//        getActivity().showProgress();
        iUpdateView.showProgress();
    }

    @Override
    public void hideProgressDialog() {
//        getActivity().hideProgress();
        iUpdateView.hideProgress();
    }

    @Override
    public void showErrorMessage(String error) {
//        getActivity().showError(error);
        iUpdateView.showError(error);
    }
}
