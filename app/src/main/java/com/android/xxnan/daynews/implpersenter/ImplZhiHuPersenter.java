package com.android.xxnan.daynews.implpersenter;

import android.content.Context;

import com.android.xxnan.daynews.IActivity.IZhiHuActivity;
import com.android.xxnan.daynews.bean.zhihu.ZhiHuBean;
import com.android.xxnan.daynews.persenter.IZhiHuPersenter;
import com.android.xxnan.daynews.utils.OkManagerUtil;
import com.google.gson.Gson;

/**
 * Created by xxnan on 2016/9/5.
 */
public class ImplZhiHuPersenter extends BasePersenter implements IZhiHuPersenter {
    private IZhiHuActivity iZhiHuActivity;
    private Context context;

    public ImplZhiHuPersenter(Context mContext, IZhiHuActivity mIZhiHuActivity) {
        context = mContext;
        iZhiHuActivity = mIZhiHuActivity;
    }

    @Override
    public void unsubcrible() {

    }

    @Override
    public void getLastZhihuNews() {
        iZhiHuActivity.showProgressDialog();
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
        String zhihupath="http://news-at.zhihu.com/api/4/news/latest";
        OkManagerUtil.getInstance().loaddata(zhihupath, new OkManagerUtil.IDataBack() {
            @Override
            public void dataBack(String data) {
                String dataString =data;
                Gson gson=new Gson();
                ZhiHuBean bean=gson.fromJson(dataString, ZhiHuBean.class);
                iZhiHuActivity.updateList(bean);
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
