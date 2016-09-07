package com.android.xxnan.daynews.api;

import com.android.xxnan.daynews.bean.zhihu.ZhiHuDays;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by xxnan on 2016/9/5.
 */
public interface ZhiHuApi {
    /**
     * @return
     * @GET("/api/4/news/latest")
     * @GET("/api/4/news/before/{date}")
     * @GET("/api/4/news/{id}")
     */
  /*  @GET("/api/4/news/latest")
    Observable<ZhiHuDays> getZhiHuDays();

    @GET("/api/4/news/before/{date}")
    Observable<ZhiHuDays> getDateDays(@Path("date") String date);*/

//    @GET("/api/4/news/{id}")
//    Observable<ZhihuStory> getZhihuStory(@Path("id") String id);
    @GET("/api/4/news/latest")
    Call<String> getZhiHuDays();

    @GET("/api/4/news/before/{date}")
    ZhiHuDays getDateDays(@Path("date") String date);
}
