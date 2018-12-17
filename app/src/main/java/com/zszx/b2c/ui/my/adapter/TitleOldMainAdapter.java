package com.zszx.b2c.ui.my.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.entity.store.StoreMainEntity;
import com.zszx.b2c.ui.classify.CheckPositionCallBack;


import java.util.List;

public class TitleOldMainAdapter extends MyBaseAdapter {
    LayoutInflater inflater;
    private Context context;
    boolean check_set = true;
    int check_position = 0;
    CheckPositionCallBack                   mCallBack;
    List<StoreMainEntity.DataBean>  datas;
    public TitleOldMainAdapter(Context context, List<StoreMainEntity.DataBean> data, CheckPositionCallBack checkPositionCallBack) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.datas = data;
        datas.get(0).checked = true;
        mCallBack = checkPositionCallBack;
    }
    @Override
    public View getContenView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        check_set = true;
        if (view == null){
            view = inflater.inflate(R.layout.item_classify_title_main_old,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.rb.setText(datas.get(i).name);
        holder.rb.setChecked(datas.get(i).checked);
        holder.rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (check_set){
                    return;
                }
                if (isChecked){
                    datas.get(check_position).checked = false;
                    datas.get(i).checked = true;
                    check_position = i;
                    notifyDataSetChanged();
                    mCallBack.checked(i);
                }
            }
        });
        check_set = false;
        return view;

    }



    @Override
    public int getNum() {
        return datas.size();
    }
    class ViewHolder{
        RadioButton rb;
        public ViewHolder(View view) {
            rb = view.findViewById(R.id.rb);
        }
    }

    public void setCheck_set(int position){
        datas.get(check_position).checked = false;
        datas.get(position).checked = true;
        check_position = position;
        notifyDataSetChanged();
    }
}

