package com.zszx.b2c.ui.my.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.ui.my.bean.TvNumBean;

import java.util.List;

//商品 和 数量  展示
public class TvNumShowAdapter extends MyBaseAdapter{
    List<TvNumBean> datas;
    Context mContext;
    LayoutInflater mInflater;

    public TvNumShowAdapter(List<TvNumBean> datas, Context context) {
        this.datas = datas;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = mInflater.inflate(R.layout.item_tv_num_show,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_name.setText(datas.get(i).name);
        holder.tv_num.setText(datas.get(i).num+"");
        return view;

    }

    @Override
    public int getNum() {
        return datas.size();
    }

    class ViewHolder{
        TextView tv_name,tv_num;
        public ViewHolder(View view) {
            tv_name =  view.findViewById(R.id.tv_name);
            tv_num =  view.findViewById(R.id.tv_num);
//            setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰

        }
    }
}
