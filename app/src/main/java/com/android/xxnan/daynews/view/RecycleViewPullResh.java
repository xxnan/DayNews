package com.android.xxnan.daynews.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2016/9/13.
 */
public class RecycleViewPullResh extends RecyclerView {
    public RecycleViewPullResh(Context context) {
        super(context);
    }

    public RecycleViewPullResh(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
