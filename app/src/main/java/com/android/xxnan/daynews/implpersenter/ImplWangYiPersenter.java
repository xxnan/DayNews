package com.android.xxnan.daynews.implpersenter;

import android.content.Context;

import com.android.xxnan.daynews.IFragment.IWngYiFragment;
import com.android.xxnan.daynews.bean.zhihu.wangyi.WangYiNewsList;
import com.android.xxnan.daynews.persenter.IWangyiPersenter;
import com.android.xxnan.daynews.utils.OkManagerUtil;
import com.google.gson.Gson;

/**
 * Created by xxnan on 2016/9/12.
 */
public class ImplWangYiPersenter extends BasePersenter implements IWangyiPersenter{
    private IWngYiFragment iWangYiFragment;
    private Context mContext;
    //http://c.m.163.com/nc/article/headline/T1348647909107/{id}-20.html
    private String path="http://c.m.163.com/nc/article/headline/T1348647909107/";
    public ImplWangYiPersenter(Context context,IWngYiFragment mIWngYiFragment)
    {
        mContext=context;
        iWangYiFragment=mIWngYiFragment;
    }
    @Override
    public void getNewsList(int id) {
        iWangYiFragment.showProgressDialog();
        path+=id+"-20.html";
        OkManagerUtil.getInstance().loadNewsData(path, new OkManagerUtil.IDataBack() {
            @Override
            public void dataBack(String data) {
                Gson gson = new Gson();
                WangYiNewsList list = gson.fromJson(data, WangYiNewsList.class);
                iWangYiFragment.upDateNews(list);
                iWangYiFragment.hideProgressDialog();
            }
        });
    }
}
