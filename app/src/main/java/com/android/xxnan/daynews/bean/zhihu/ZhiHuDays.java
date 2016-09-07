package com.android.xxnan.daynews.bean.zhihu;

import java.util.ArrayList;

/**
 * Created by xxnan on 2016/9/5.
 */
public class ZhiHuDays {
//    @SerializedName("date")
    private String date;
//    @SerializedName("top_stories")
    private ArrayList<ZhiHuDaysItem> mZhiHuDaysItem;
//    @SerializedName("stories")
    private ArrayList<ZhiHuDaysItem> stories;

    public String getDate() {
        return date;
    }

    public ArrayList<ZhiHuDaysItem> getmZhiHuDaysItem() {
        return mZhiHuDaysItem;
    }

    public ArrayList<ZhiHuDaysItem> getStories() {
        return stories;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setmZhiHuDaysItem(ArrayList<ZhiHuDaysItem> mZhiHuDaysItem) {
        this.mZhiHuDaysItem = mZhiHuDaysItem;
    }

    public void setStories(ArrayList<ZhiHuDaysItem> stories) {
        this.stories = stories;
    }
}
