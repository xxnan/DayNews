package com.android.xxnan.daynews.bean.zhihu;

import java.util.List;

/**
 * Created by xxnan on 2016/9/7.
 */
public class ZhiHuBean {
    String date;
    List<ZhiHuStories> stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(List<ZhiHuStories> stories) {
        this.stories =  stories;
    }

    public String getDate() {
        return date;
    }

    public List<ZhiHuStories> getStories() {
        return stories;
    }
}
