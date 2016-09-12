package com.android.xxnan.daynews.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.xxnan.daynews.R;
import com.android.xxnan.daynews.bean.zhihu.wangyi.WangYiBean;
import com.android.xxnan.daynews.utils.OkManagerUtil;

import java.util.ArrayList;

/**
 * Created by xxnan on 2016/9/12.
 */
public class WangYiRecycleAdapter extends RecyclerView.Adapter<MyNewsHolder> {
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
    public MyNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.news_item,null);
        return new MyNewsHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyNewsHolder holder, int position) {
        OkManagerUtil.getInstance().loadBitmap(list.get(position).getImgsrc(), new OkManagerUtil.IBitmapBack() {
            @Override
            public void bitmapBack(final Bitmap bitmap) {
                holder.imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        holder.imageView.setImageBitmap(bitmap);
                    }
                });
            }
        });
        holder.item_text_news.setText(list.get(position).getTitle());
        holder.item_text_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.newsSource.setText(list.get(position).getSource());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
class MyNewsHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView item_text_news;
        TextView newsSource;

        public MyNewsHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_image_news);
            item_text_news = (TextView) itemView.findViewById(R.id.item_text_news);
            newsSource = (TextView) itemView.findViewById(R.id.item_text_source_news);
        }
    }
