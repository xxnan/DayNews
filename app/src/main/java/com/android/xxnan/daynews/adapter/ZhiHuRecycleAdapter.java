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
import com.android.xxnan.daynews.bean.zhihu.ZhiHuStories;
import com.android.xxnan.daynews.utils.OkManagerUtil;

import java.util.ArrayList;

/**
 * Created by xxnan on 2016/9/5.
 */
public class ZhiHuRecycleAdapter extends RecyclerView.Adapter<MyHolder> {
    private ArrayList<ZhiHuStories> mZhiHuStories;
    private Context mContext;

    public ZhiHuRecycleAdapter(Context context, ArrayList<ZhiHuStories> zhiHuStories) {
        mContext = context;
        mZhiHuStories = zhiHuStories;
    }



    public void setData( ArrayList<ZhiHuStories> zhiHuStories)
    {
        mZhiHuStories=zhiHuStories;
        notifyDataSetChanged();
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.zhihu_recycle_item, null));
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {

        OkManagerUtil.getInstance().loadBitmap(mZhiHuStories.get(position).getImages()[0], new OkManagerUtil.IBitmapBack() {
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
        holder.title.setText(mZhiHuStories.get(position).getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mZhiHuStories.size();
    }
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
