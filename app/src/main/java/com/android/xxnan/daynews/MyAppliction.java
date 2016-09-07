package com.android.xxnan.daynews;

import android.app.Application;
import android.content.Context;

/**
 * Created by xxnan on 2016/9/7.
 */
public class MyAppliction extends Application{
    private static Context context;
    public MyAppliction()
    {
        context=this;
    }
    public static Context getApplictionContext()
    {
        return context;
    }
}
