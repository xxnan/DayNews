package com.android.xxnan.daynews.bean.zhihu.wangyi;

import java.io.Serializable;

/**
 * Created by xxnan on 2016/9/12.
 */
public class WangYiBean implements Serializable{

    /**
     * docid
     */
    private String docid;
    /**
     * 标题
     */
    private String title;
    /**
     * 小内容
     */
    private String digest;
    /**
     * 图片地址
     */
    private String imgsrc;
    /**
     * 来源
     */
    private String source;
    /**
     * 时间
     */
    private String ptime;

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    /**

     * TAG
     */
    private String tag;

    public String getDocid() {
        return docid;
    }

    public String getTitle() {
        return title;
    }

    public String getDigest() {
        return digest;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getSource() {
        return source;
    }

    public String getPtime() {
        return ptime;
    }

    public String getTag() {
        return tag;
    }
}
