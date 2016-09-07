package com.android.xxnan.daynews.bean.zhihu;

import java.util.ArrayList;

/**
 * Created by xxnan on 2016/9/7.
 */
public class ZhiHuBean {
    String date;
    ArrayList<ZhiHuStories> stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(ArrayList<ZhiHuStories> stories) {
        this.stories =  stories;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<ZhiHuStories> getStories() {
        return stories;
    }
}
