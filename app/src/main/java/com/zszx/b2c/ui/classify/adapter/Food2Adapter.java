package com.zszx.b2c.ui.classify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.entity.classify.ClassTitleBean;
import com.zszx.b2c.net.ConstantUtils;

import java.util.List;

public class Food2Adapter extends MyBaseAdapter {
    LayoutInflater inflater;
    private Context context;
    List<ClassTitleBean.DataBeanX.DataBean.SunBeanX>  datas;


    public Food2Adapter(Context context, List<ClassTitleBean.DataBeanX.DataBean.SunBeanX> sunBeanX) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.datas = sunBeanX;
    }

    @Override
    public View getContenView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_classfy, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(ConstantUtils.base_url_host+datas.get(i).image).into(holder.iv);
        holder.tv_name.setText(datas.get(i).name);
        return view;

    }


    @Override
    public int getNum() {
        return datas.size();
    }

    class ViewHolder {
        TextView  tv_name;
        ImageView iv;

        public ViewHolder(View view) {
            tv_name = view.findViewById(R.id.tv_name);
            iv = view.findViewById(R.id.iv);
        }
    }

}
