package com.zszx.b2c.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.entity.home.HomeEntity;
import com.zszx.b2c.net.ConstantUtils;
import com.zszx.b2c.ui.my.ProductDetailsActivity;
import com.zszx.b2c.utils.ToastUtil;

import java.util.List;

/**
 * Created by wxm on 2018/11/14.
 * 购物页面 adapter
 * 热卖商品
 */
public class FoodBuyShowAdapter extends MyBaseAdapter {
    LayoutInflater inflater;
    private Context context;
    List<HomeEntity.DataBean.HotprojectBean> datas;
    public FoodBuyShowAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    public FoodBuyShowAdapter(Context context, List<HomeEntity.DataBean.HotprojectBean> hotproject) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        datas = hotproject;
    }
    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = inflater.inflate(R.layout.item_food_buy,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        if (datas != null){
        holder.tv_name.setText(datas.get(i).name);
        holder.tv_price_discount.setText(datas.get(i).price_discount+"");
        holder.tv_price_market.setText(datas.get(i).price_market+"");
            if (datas.get(i).full != null){
                holder.tv_full.setVisibility(View.VISIBLE);
                holder.tv_full.setText(datas.get(i).full.get(0).name);
            }else {
                holder.tv_full.setVisibility(View.GONE);
            }
        Glide.with(context).load(ConstantUtils.base_url_host+datas.get(i).image).into(holder.iv_back);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ProductDetailsActivity.class));
            }
        });
        holder.iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"添加到购物车");
            }
        });
        return view;

    }



    @Override
    public int getNum() {
        if (datas!= null){
            return datas.size();
        }
        return 8;
    }
    class ViewHolder{
        private ImageView iv_back;
        private TextView tv_name;
        private TextView tv_price_discount;
        private TextView tv_price_market;
        private TextView tv_full;
        private ImageView iv_add;
        public ViewHolder(View view) {


            iv_back =  view.findViewById(R.id.iv_back);
            iv_add =  view.findViewById(R.id.iv_add);
            tv_name =  view.findViewById(R.id.tv_name);
            tv_price_discount =  view.findViewById(R.id.tv_price_discount);
            tv_price_market =  view.findViewById(R.id.tv_price_market);
            tv_full =  view.findViewById(R.id.tv_full);
            tv_price_market.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
//            setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰

        }
    }
}
