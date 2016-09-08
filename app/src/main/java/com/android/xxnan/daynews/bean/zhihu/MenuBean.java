package com.android.xxnan.daynews.bean.zhihu;

/**
 * Created by xxnan on 2016/9/8.
 */
public class MenuBean {
    private int iconId;

    public String getTitle() {
        return title;
    }

    public int getIconId() {
        return iconId;
    }

    private String title;

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
