package com.android.xxnan.daynews.implpersenter;

import android.content.Context;

import com.android.xxnan.daynews.IActivity.IZhiHuActivity;
import com.android.xxnan.daynews.api.ZhiHuApi;
import com.android.xxnan.daynews.bean.zhihu.ZhiHuDays;
import com.android.xxnan.daynews.persenter.IZhiHuPersenter;

import retrofit2.Retrofit;

/**
 * Created by xxnan on 2016/9/5.
 */
public class ImplZhiHuPersenter implements IZhiHuPersenter{
    private IZhiHuActivity iZhiHuActivity;
    private Context context;
   public ImplZhiHuPersenter(Context mContext,IZhiHuActivity mIZhiHuActivity)
    {
        context=mContext;
        iZhiHuActivity=mIZhiHuActivity;
    }

    @Override
    public void unsubcrible() {

    }

    @Override
    public void getLastZhihuNews() {
        iZhiHuActivity.showProgressDialog();
//        Subscription subscription=
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://news-at.zhihu.com").build();
        ZhiHuApi zhiHuApi=retrofit.create(ZhiHuApi.class);
        ZhiHuDays zhiHuDays=zhiHuApi.getZhiHuDays();
        iZhiHuActivity.updateList(zhiHuDays);
    }

    @Override
    public void getTheDaily(String date) {

    }

    @Override
    public void getLastFromCache() {

    }
}
