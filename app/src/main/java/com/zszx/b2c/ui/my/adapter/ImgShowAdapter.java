package com.zszx.b2c.ui.my.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.ui.my.bean.TvNumBean;

import java.util.List;

public class ImgShowAdapter extends MyBaseAdapter {
    List<String> datas;
    Context         mContext;
    LayoutInflater  mInflater;

    public ImgShowAdapter(List<String> datas, Context context) {
        this.datas = datas;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = mInflater.inflate(R.layout.item_img_show,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        return view;

    }

    @Override
    public int getNum() {
        return datas.size();
    }

    class ViewHolder{
        ImageView iv;
        public ViewHolder(View view) {
            iv =  view.findViewById(R.id.iv);
        }
    }
}
