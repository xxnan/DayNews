package com.android.xxnan.daynews.bean.zhihu;

/**
 * Created by xxnan on 2016/9/5.
 */
public class ZhiHuDaysItem {
//    @SerializedName("images")
    private String[] images;
//    @SerializedName("type")
    private int type;
//    @SerializedName("id")
    private String id;
//    @SerializedName("title")
    private String title;
    private String date;
    public boolean hasFadedIn = false;

    public String[] getImages() {
        return images;
    }

    public int getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public boolean isHasFadedIn() {
        return hasFadedIn;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHasFadedIn(boolean hasFadedIn) {
        this.hasFadedIn = hasFadedIn;
    }
}
