package com.android.xxnan.daynews.bean.zhihu;

/**
 * Created by xxnan on 2016/9/7.
 */
public class ZhiHuStories {
    String [] images;
    String type;
    String title;
    String id;
    String ga_prefix;

    public String[] getImages() {
        return images;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setImages(String[] names) {
        this.images = names;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }
}
