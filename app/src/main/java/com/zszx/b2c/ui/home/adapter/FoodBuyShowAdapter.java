package com.zszx.b2c.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.ui.my.ProductDetailsActivity;
import com.zszx.b2c.utils.ToastUtil;

/**
 * Created by wxm on 2018/11/14.
 * 购物页面 adapter
 */
public class FoodBuyShowAdapter extends MyBaseAdapter {
    LayoutInflater inflater;
    private Context context;
    public FoodBuyShowAdapter( Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);

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
        return 3;
    }
    class ViewHolder{
        TextView tv;
        ImageView iv_add;
        public ViewHolder(View view) {

            tv =  view.findViewById(R.id.tv_parce2);
            iv_add =  view.findViewById(R.id.iv_add);
            tv.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
//            setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰

        }
    }
}
