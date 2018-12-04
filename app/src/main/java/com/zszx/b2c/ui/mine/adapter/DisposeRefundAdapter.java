package com.zszx.b2c.ui.mine.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
// 退货处理进度
public class DisposeRefundAdapter  extends MyBaseAdapter {
    private Context        mContext;
    private LayoutInflater mInflater;

    public DisposeRefundAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view =  mInflater.inflate(R.layout.item_disporse_show,null );
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        if (i ==0){
            holder.ll_back.setBackgroundColor(R.color.font_gray2);
        }else if (i==1){
            holder.ll_back.setBackgroundColor(R.color.font_green);

        }else if (i ==2 ){
            holder.ll_back.setBackgroundColor(R.color.red);
        }else {

        }
        return view;
    }

    @Override
    public int getNum() {
        return 4;
    }

    class ViewHolder{
        private LinearLayout ll_back;

        public ViewHolder(View view) {
            ll_back = view.findViewById(R.id.ll_back);

        }
    }
}
