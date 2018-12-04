package com.zszx.b2c.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.ui.my.OldStoreMainActivity;
import com.zszx.b2c.utils.ToastUtil;

/**
 * Created by wxm on 2018/11/14.
 * 特色食品
 */
public class SpecialAdapter extends MyBaseAdapter {
    LayoutInflater inflater;
    private Context context;
    public SpecialAdapter( Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);

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
        return 3;
    }
    class ViewHolder{
        TextView tv_parce1,tv_parce2,tv_parce3;
        public ViewHolder(View view) {

            tv_parce1 =  view.findViewById(R.id.tv_parce1);
            tv_parce1.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
            tv_parce2 =  view.findViewById(R.id.tv_parce2);
            tv_parce2.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
            tv_parce3 =  view.findViewById(R.id.tv_parce3);
            tv_parce3.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线

//            setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰

        }
    }
}
