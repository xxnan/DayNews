package com.android.xxnan.daynews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.xxnan.daynews.R;
import com.android.xxnan.daynews.bean.zhihu.MenuBean;

import java.util.List;

/**
 * Created by xxnan on 2016/9/8.
 */
public class MeunAdapter extends BaseAdapter {
    private List<MenuBean> mList;
    private Context mContext;

    public MeunAdapter(Context context, List<MenuBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MuneHolder muneHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.mune_item, null);
            muneHolder = new MuneHolder();
            muneHolder.mune_title = (TextView) convertView.findViewById(R.id.mune_title);
            muneHolder.icon= (ImageView) convertView.findViewById(R.id.mune_icon);
            convertView.setTag(muneHolder);
        } else {
            muneHolder = (MuneHolder) convertView.getTag();
        }
        muneHolder.mune_title.setText(mList.get(position).getTitle());
        muneHolder.icon.setBackgroundResource(mList.get(position).getIconId());
        return convertView;
    }

    class MuneHolder {
        TextView mune_title;
        ImageView icon;
    }
}
