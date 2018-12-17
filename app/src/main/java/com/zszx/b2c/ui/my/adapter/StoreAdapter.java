package com.zszx.b2c.ui.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.entity.store.StoreMainEntity;
import com.zszx.b2c.net.ConstantUtils;
import com.zszx.b2c.ui.my.OldStoreMainActivity;

import java.util.List;

public class StoreAdapter  extends MyBaseAdapter {
    Context                             mContext;
    LayoutInflater                      mInflater;
    List<StoreMainEntity.DataBean.ShopBean> datas;
    public StoreAdapter(List<StoreMainEntity.DataBean.ShopBean>  datas, Context context) {
        this.datas = datas;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = mInflater.inflate(R.layout.item_store_show,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(mContext).load(ConstantUtils.base_url_host+datas.get(i).image).into(holder.iv_back);
        Glide.with(mContext).load(ConstantUtils.base_url_host+datas.get(i).log_image).into(holder.iv_log);
        holder.tv_name.setText(datas.get(i).name);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, OldStoreMainActivity.class));
            }
        });
        return view;

    }

    @Override
    public int getNum() {
        return datas.size();
    }

    class ViewHolder{
        ImageView iv_log;
        ImageView iv_back;
        TextView  tv_name;
        public ViewHolder(View view) {
            iv_log =  view.findViewById(R.id.iv_log);
            iv_back =  view.findViewById(R.id.iv_back);
            tv_name =  view.findViewById(R.id.tv_name);
        }
    }
}
