package com.zszx.b2c.ui.mine.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;

public class RefundAdapter extends MyBaseAdapter {
    private Context        mContext;
    private LayoutInflater mInflater;

    public RefundAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view =  mInflater.inflate(R.layout.item_refund_show,null );
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        return view;
    }

    @Override
    public int getNum() {
        return 4;
    }

    class ViewHolder{
        private CheckBox  cb;
        private TextView  tv_name;
        private TextView  iv_prace1;
        private TextView  tv_prace2;
        private TextView  tv_describe;
        private TextView  tv_num;
        private ImageView iv_del;
        private ImageView iv_add;

        private ViewHolder(View view) {
            cb =  view.findViewById(R.id.cb);
            tv_name =  view.findViewById(R.id.tv_name);
            iv_prace1 =  view.findViewById(R.id.iv_prace1);
            tv_prace2 =  view.findViewById(R.id.tv_prace2);
            tv_describe =  view.findViewById(R.id.tv_describe);
            iv_del =  view.findViewById(R.id.iv_del);
            iv_add =  view.findViewById(R.id.iv_add);
            tv_num =  view.findViewById(R.id.tv_num);

        }
    }
}
