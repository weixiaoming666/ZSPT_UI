package com.zszx.b2c.ui.classify.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.view.PopClassifySearchDialog;


public class ClassifySearchAdapter extends MyBaseAdapter {

    LayoutInflater inflater;
    private Context context;
    public ClassifySearchAdapter( Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public View getContenView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = inflater.inflate(R.layout.item_classify_search,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        return view;

    }



    @Override
    public int getNum() {
        return 50;
    }
    class ViewHolder{
        TextView tv;
        public ViewHolder(View view) {

        }
    }
}