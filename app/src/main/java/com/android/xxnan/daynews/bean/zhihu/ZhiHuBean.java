package com.android.xxnan.daynews.bean.zhihu;

/**
 * Created by xxnan on 2016/9/7.
 */
public class ZhiHuBean {
    String date;
    ZhiHuStories stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(ZhiHuStories stories) {
        this.stories = stories;
    }

    public String getDate() {
        return date;
    }

    public ZhiHuStories getStories() {
        return stories;
    }
}
