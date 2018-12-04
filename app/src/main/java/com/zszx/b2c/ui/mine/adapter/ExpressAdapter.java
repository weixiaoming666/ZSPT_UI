package com.zszx.b2c.ui.mine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;

//快递路线
public class ExpressAdapter extends MyBaseAdapter{
    private Context        mContext;
    private LayoutInflater mInflater;

    public ExpressAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view =  mInflater.inflate(R.layout.item_express_show,null );
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        if (i == 0){
            holder.view_line.setVisibility(View.GONE);
        }else {
            holder.view_line.setVisibility(View.VISIBLE);
        }
        return view;
    }

    @Override
    public int getNum() {
        return 6;
    }

    class ViewHolder{
        private TextView tv_details;
        private TextView tv_time;
        private TextView tv_day;
        private View view_line;
        public ViewHolder(View view) {
            tv_details = view.findViewById(R.id.tv_details);
            tv_time = view.findViewById(R.id.tv_time);
            tv_day = view.findViewById(R.id.tv_day);
            view_line = view.findViewById(R.id.view_line);
        }
    }
}
