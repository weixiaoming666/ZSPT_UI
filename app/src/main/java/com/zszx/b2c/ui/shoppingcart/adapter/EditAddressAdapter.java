package com.zszx.b2c.ui.shoppingcart.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.utils.ToastUtil;

public class EditAddressAdapter extends MyBaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;

    public EditAddressAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
           view =  mInflater.inflate(R.layout.item_edit_address,null );
           holder = new ViewHolder(view);
           view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.ll_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(mContext,"删除地址");
            }
        });
        holder.ll_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(mContext,"修改地址");
            }
        });
        return view;
    }

    @Override
    public int getNum() {
        return 6;
    }

    class ViewHolder{
        private TextView     tv_name;
        private TextView     tv_phone;
        private TextView     tv_address;
        private CheckBox     cb;
        private LinearLayout ll_del;
        private LinearLayout ll_edit;

        public ViewHolder(View view) {
            tv_name = view.findViewById(R.id.tv_name);
            tv_phone = view.findViewById(R.id.tv_phone);
            tv_address = view.findViewById(R.id.tv_address);
            cb = view.findViewById(R.id.cb);
            ll_del = view.findViewById(R.id.ll_del);
            ll_edit = view.findViewById(R.id.ll_edit);
        }
    }
}
