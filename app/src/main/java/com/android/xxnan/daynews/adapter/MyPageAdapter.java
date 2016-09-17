package com.android.xxnan.daynews.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xxnan on 2016/9/17.
 */
public class MyPageAdapter extends PagerAdapter{
    private List<View>list;
    public MyPageAdapter(List<View>  mlist)
    {
        this.list=mlist;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewGroup) container).removeView((View) object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=list.get(position);
        container.addView(view);
        return view;
    }
}
