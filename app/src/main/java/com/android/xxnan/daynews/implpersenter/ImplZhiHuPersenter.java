package com.android.xxnan.daynews.implpersenter;

import android.content.Context;

import com.android.xxnan.daynews.IFragment.IZhiHuFragment;
import com.android.xxnan.daynews.bean.zhihu.ZhiHuBean;
import com.android.xxnan.daynews.persenter.IZhiHuPersenter;
import com.android.xxnan.daynews.utils.OkManagerUtil;
import com.google.gson.Gson;

/**
 * Created by xxnan on 2016/9/5.
 */
public class ImplZhiHuPersenter extends BasePersenter implements IZhiHuPersenter {
    private IZhiHuFragment iZhiHuFragment;
    private Context context;
    public ImplZhiHuPersenter(Context mContext, IZhiHuFragment mIZhiHuFragment) {
        context = mContext;
        iZhiHuFragment = mIZhiHuFragment;
    }

    @Override
    public void unsubcrible() {

    }

    @Override
    public void getLastZhihuNews() {
        iZhiHuFragment.showProgressDialog();
      /*  ZhiHuApi zhiHuApi=ApiManage.getInstence().getZhihuApiService();
        Call<String> call= zhiHuApi.getZhiHuDays();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.print(response);
                response.body();
//                iZhiHuActivity.updateList(response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });*/
        String zhihupath = "http://news-at.zhihu.com/api/4/news/latest";
        OkManagerUtil.getInstance().loaddata(zhihupath, new OkManagerUtil.IDataBack() {
            @Override
            public void dataBack(final String data) {
                Gson gson = new Gson();
                ZhiHuBean bean = gson.fromJson(data, ZhiHuBean.class);
                iZhiHuFragment.updateList(bean);
                iZhiHuFragment.hideProgressDialog();
            }
        });
    }

    @Override
    public void getTheDaily(String date) {

    }

    @Override
    public void getLastFromCache() {

    }
}
