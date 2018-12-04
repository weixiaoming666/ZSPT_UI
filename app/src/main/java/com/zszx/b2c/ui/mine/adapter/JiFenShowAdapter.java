package com.zszx.b2c.ui.mine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.ui.shoppingcart.adapter.EditAddressAdapter;

public class JiFenShowAdapter extends MyBaseAdapter {

    private Context        mContext;
    private LayoutInflater mInflater;

    public JiFenShowAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view =  mInflater.inflate(R.layout.item_jifen_show,null );
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        return view;
    }

    @Override
    public int getNum() {
        return 20;
    }

    class ViewHolder{
        private TextView tv_name;
        private TextView tv_time;
        private TextView tv_jifen;
        public ViewHolder(View view) {
            tv_name = view.findViewById(R.id.tv_name);
            tv_time = view.findViewById(R.id.tv_time);
            tv_jifen = view.findViewById(R.id.tv_jifen);
        }
    }
}
