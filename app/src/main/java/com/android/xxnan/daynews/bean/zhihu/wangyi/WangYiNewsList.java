package com.android.xxnan.daynews.bean.zhihu.wangyi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by xxnan on 2016/9/12.
 */
public class WangYiNewsList {
    @SerializedName("T1348647909107")
    ArrayList<WangYiBean> newsList;

    public ArrayList<WangYiBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<WangYiBean> newsList) {
        this.newsList = newsList;
    }
}
