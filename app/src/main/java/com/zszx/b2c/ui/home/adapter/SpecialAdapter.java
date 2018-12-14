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
import com.zszx.b2c.ui.my.OldStoreMainActivity;
import com.zszx.b2c.utils.ToastUtil;

import java.util.List;

/**
 * Created by wxm on 2018/11/14.
 * 特色食品
 */
public class SpecialAdapter extends MyBaseAdapter {
    LayoutInflater inflater;
    private Context context;
    List<HomeEntity.DataBean.ShopBean> datas;
    public SpecialAdapter( Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);

    }
    public SpecialAdapter( Context context, List<HomeEntity.DataBean.ShopBean> shop) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        datas = shop;
    }
    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
       ViewHolder holder;
        if (view == null){
            view = inflater.inflate(R.layout.item_food_special,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        if (datas !=null){
            Glide.with(context).load(ConstantUtils.base_url_host+datas.get(i).black_image).into(  holder.iv_home_store_bg);
            Glide.with(context).load(ConstantUtils.base_url_host+datas.get(i).log_image).into(  holder.iv_icon);
            holder.tv_name.setText(datas.get(i).name+"");
            if (datas.get(i).prject!=null){
                Glide.with(context).load(ConstantUtils.base_url_host+datas.get(i).prject.get(0).image).into(  holder.iv_item_1);
                Glide.with(context).load(ConstantUtils.base_url_host+datas.get(i).prject.get(1).image).into(  holder.iv_item_2);
                Glide.with(context).load(ConstantUtils.base_url_host+datas.get(i).prject.get(2).image).into(  holder.iv_item_3);
                holder.tv_item_name_1.setText(datas.get(i).prject.get(0).name);
                holder.tv_item_name_2.setText(datas.get(i).prject.get(1).name);
                holder.tv_item_name_3.setText(datas.get(i).prject.get(2).name);
                holder.tv_item_price_red_1.setText(datas.get(i).prject.get(0).price_discount+"");
                holder.tv_item_price_red_2.setText(datas.get(i).prject.get(1).price_discount+"");
                holder.tv_item_price_red_3.setText(datas.get(i).prject.get(2).price_discount+"");
                holder.tv_item_price_gray_1.setText(datas.get(i).prject.get(0).price_market+"");
                holder.tv_item_price_gray_2.setText(datas.get(i).prject.get(1).price_market+"");
                holder.tv_item_price_gray_3.setText(datas.get(i).prject.get(2).price_market+"");
            }
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"店铺6-1");
                context.startActivity(new Intent(context, OldStoreMainActivity.class));
            }
        });
        return view;

    }



    @Override
    public int getNum() {
        if (datas != null){
            return datas.size();
        }
        return 3;
    }
    class ViewHolder{
        private ImageView iv_home_store_bg;
        private ImageView iv_icon;//顶部店铺商标
        private TextView tv_name;
        private TextView tv_num_select;
        private TextView tv_shop;//进店
        private android.support.v7.widget.CardView card_1;
        private ImageView iv_item_1;
        private TextView tv_item_name_1;
        private TextView tv_item_price_red_1;
        private TextView tv_item_price_gray_1;
        private android.support.v7.widget.CardView card_2;
        private ImageView iv_item_2;
        private TextView tv_item_name_2;
        private TextView tv_item_price_red_2;
        private TextView tv_item_price_gray_2;
        private android.support.v7.widget.CardView card_3;
        private ImageView iv_item_3;
        private TextView tv_item_name_3;
        private TextView tv_item_price_red_3;
        private TextView tv_item_price_gray_3;

        public ViewHolder(View view) {

            iv_home_store_bg =  view.findViewById(R.id.iv_home_store_bg);
            iv_icon =  view.findViewById(R.id.iv_icon);
            tv_name =  view.findViewById(R.id.tv_name);
            tv_num_select =  view.findViewById(R.id.tv_num_select);
            tv_shop =  view.findViewById(R.id.tv_shop);

            card_1 =  view.findViewById(R.id.card_1);
            iv_item_1 =  view.findViewById(R.id.iv_item_1);
            tv_item_name_1 =  view.findViewById(R.id.tv_item_name_1);
            tv_item_price_red_1 =  view.findViewById(R.id.tv_item_price_red_1);
            tv_item_price_gray_1 =  view.findViewById(R.id.tv_item_price_gray_1);

            card_2 =  view.findViewById(R.id.card_2);
            iv_item_2 =  view.findViewById(R.id.iv_item_2);
            tv_item_name_2 =  view.findViewById(R.id.tv_item_name_2);
            tv_item_price_red_2 =  view.findViewById(R.id.tv_item_price_red_2);
            tv_item_price_gray_2 =  view.findViewById(R.id.tv_item_price_gray_2);

            card_3 =  view.findViewById(R.id.card_3);
            iv_item_3 =  view.findViewById(R.id.iv_item_3);
            tv_item_name_3 =  view.findViewById(R.id.tv_item_name_3);
            tv_item_price_red_3 =  view.findViewById(R.id.tv_item_price_red_3);
            tv_item_price_gray_3 =  view.findViewById(R.id.tv_item_price_gray_3);

            tv_item_price_gray_3.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
            tv_item_price_gray_2.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
            tv_item_price_gray_1.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线

//            setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰

        }
    }
}
