package com.android.xxnan.daynews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.xxnan.daynews.R;
import com.android.xxnan.daynews.bean.zhihu.wangyi.WangYiBean;

import java.util.ArrayList;

/**
 * Created by xxnan on 2016/9/12.
 */
public class WangYiRecycleAdapter extends RecyclerView.Adapter<MyHolder> {

    private Context context;
    private ArrayList<WangYiBean> list;
    public WangYiRecycleAdapter(Context mContext, ArrayList<WangYiBean> mlist)
    {
        context=mContext;
        list= mlist;
    }

    public void setList(ArrayList<WangYiBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public com.android.xxnan.daynews.adapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(com.android.xxnan.daynews.adapter.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_zhihu_imageview);
            title = (TextView) itemView.findViewById(R.id.item_zhihu_title);
        }
    }
}
