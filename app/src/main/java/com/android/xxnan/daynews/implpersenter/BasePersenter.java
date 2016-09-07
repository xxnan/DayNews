package com.android.xxnan.daynews.implpersenter;

import com.android.xxnan.daynews.persenter.IBasePersenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by xxnan on 2016/9/7.
 */
public class BasePersenter implements IBasePersenter {
    private CompositeSubscription mCompositeSubscription;

    protected void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }
    @Override
    public void unsubcrible() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
