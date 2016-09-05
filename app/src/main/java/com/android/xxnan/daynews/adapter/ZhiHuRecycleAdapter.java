package com.android.xxnan.daynews.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.xxnan.daynews.R;
import com.android.xxnan.daynews.bean.zhihu.ZhiHuDaysItem;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by xxnan on 2016/9/5.
 */
public class ZhiHuRecycleAdapter extends RecyclerView.Adapter<MyHolder> {
    private ArrayList<ZhiHuDaysItem> mZhiHuDaysItems;
    private Context mContext;

    public ZhiHuRecycleAdapter(Context context, ArrayList<ZhiHuDaysItem> zhiHuDaysItems) {
        mContext = context;
        mZhiHuDaysItems = zhiHuDaysItems;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.zhihu_recycle_item, null));
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        Bitmap bitmap = null;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(mZhiHuDaysItems.get(position).getImages()[0])
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful())
                {
                    byte[] data=response.body().bytes();
                    final Bitmap bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
                    holder.imageView.post(new Runnable() {
                        @Override
                        public void run() {
                            holder.imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
        holder.title.setText(mZhiHuDaysItems.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mZhiHuDaysItems.size();
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
