package com.android.xxnan.daynews.utils;

import com.android.xxnan.daynews.api.ZhiHuApi;
import com.squareup.okhttp.OkHttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/9/13.
 */
public class RetrfitUtil {
    private static RetrfitUtil instance;

    private OkHttpClient okHttpClient;

    public static RetrfitUtil getInstance() {
        if (instance == null) {
            synchronized (OkManagerUtil.class) {
                if (instance == null)
                    instance = new RetrfitUtil();
            }
        }
        return instance;
    }

    public void LoadZhiHuData(String basePath)
    {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(basePath)
//                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ZhiHuApi zhiHuApi=retrofit.create(ZhiHuApi.class);
        Call<String> call=zhiHuApi.getZhiHuDays();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
