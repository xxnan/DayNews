package com.android.xxnan.daynews.persenter;

/**
 * Created by xxnan on 2016/9/5.
 */
public interface IZhiHuPersenter extends IBasePersenter{
    void getLastZhihuNews();

    void getTheDaily(String date);

    void getLastFromCache();
}
