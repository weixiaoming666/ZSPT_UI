package com.zszx.b2c.ui.classify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.entity.classify.ClassTitleBean;
import com.zszx.b2c.ui.classify.CheckPositionCallBack;
import com.zszx.b2c.view.MyGradView;

import java.util.List;

public class RecAdapter extends MyBaseAdapter {
    LayoutInflater inflater;
    private Context context;
    List<ClassTitleBean.DataBeanX.RecBean>  datas;
    public RecAdapter(Context context,   List<ClassTitleBean.DataBeanX.RecBean>  data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.datas = data;

    }
    @Override
    public View getContenView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = inflater.inflate(R.layout.item_classify_rec_show,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_name.setText(datas.get(i).name);
        holder.gv_food.setAdapter(new FoodAdapter(context,datas.get(i).sun));
        return view;

    }



    @Override
    public int getNum() {
        return datas.size();
    }
    class ViewHolder{
        TextView   tv_name;
        MyGradView gv_food;
        public ViewHolder(View view) {
            tv_name = view.findViewById(R.id.tv_name);
            gv_food = view.findViewById(R.id.gv_food);
        }
    }

}

