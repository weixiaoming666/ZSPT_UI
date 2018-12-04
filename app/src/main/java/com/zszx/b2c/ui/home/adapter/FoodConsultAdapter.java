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
//食物资讯

public class FoodConsultAdapter extends MyBaseAdapter {
    LayoutInflater inflater;
    private Context context;
    public FoodConsultAdapter( Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = inflater.inflate(R.layout.item_food_consult,null);
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
        return view;

    }



    @Override
    public int getNum() {
        return 3;
    }
    class ViewHolder{
        private ImageView iv;
        private TextView  tv_from;
        private TextView  tv_num;
        private TextView  tv_time;
        public ViewHolder(View view) {

            tv_from =  view.findViewById(R.id.tv_from);
            tv_num =  view.findViewById(R.id.tv_num);
            tv_time =  view.findViewById(R.id.tv_time);
            iv =  view.findViewById(R.id.iv);


        }
    }
}
