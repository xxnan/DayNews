package com.android.xxnan.daynews.IFragment;


import android.support.v4.app.Fragment;

import com.android.xxnan.daynews.bean.zhihu.wangyi.WangYiNewsList;

/**
 * A simple {@link Fragment} subclass.
 */
public interface IWngYiFragment extends IBaseFragment{
    void upDateNews(WangYiNewsList newsList);

}
