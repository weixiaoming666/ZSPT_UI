package com.zszx.b2c.ui.mine.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;

public class CouponAdapter extends MyBaseAdapter {
    private Context        mContext;
    private LayoutInflater mInflater;

    public CouponAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view =  mInflater.inflate(R.layout.item_coupon_show,null );
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        if (i ==2 || i == 5){
            holder.ll_back.setImageResource(R.drawable.user_youhuijuan_yiyong_bg);
        }else {
            holder.ll_back.setImageResource(R.drawable.user_youhuijuan_keyong_bg);

        }
        return view;
    }

    @Override
    public int getNum() {
        return 20;
    }

    class ViewHolder{
        private ImageView ll_back;
        private TextView  tv_type;
        private TextView  tv_state;
        private TextView  tv_time;
        private TextView  tv_money;
        private TextView  tv_tioajian;
        public ViewHolder(View view) {
            ll_back = view.findViewById(R.id.ll_back);
            tv_type = view.findViewById(R.id.tv_type);
            tv_state = view.findViewById(R.id.tv_state);
            tv_time = view.findViewById(R.id.tv_time);
            tv_money = view.findViewById(R.id.tv_money);
            tv_tioajian = view.findViewById(R.id.tv_tioajian);
        }
    }
}
