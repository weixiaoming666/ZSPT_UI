package com.zszx.b2c.ui.mine.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.shoppingcart.activity.OrderActivity;
import com.zszx.b2c.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class OrderElvDetiallsAdapter extends BaseExpandableListAdapter {
    public  Map<Integer,Boolean> mList   = new HashMap<>();
    private boolean              checked = false;
    private Context        mContext;
    private LayoutInflater mInflater;
    public OrderElvDetiallsAdapter(Context context) {
        mContext = context;
        this.mInflater =LayoutInflater.from(mContext);
        for (int i = 0; i < 3; i++) {
            mList.put(0,false);
            mList.put(1,false);
            mList.put(2,false);

        }
    }


    @Override
    public int getGroupCount() {
        return 3;
    }

    //    获取成员个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return 3;
    }
    // 获取组
    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }
    //  获取列表
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }
    // 获取组id
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    //获取子id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 10;
    }
    // 状态id
    @Override
    public boolean hasStableIds() {
        return false;
    }
    //获取组view
    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.item_order_group,null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        return convertView;
    }
    // 获取子view
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ChildViewHolder childViewHolder;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.item_order_detials_child,null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        }else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        return convertView;

    }
    // ziview 被选中状态
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }



    class GroupViewHolder{
        private TextView     tv_time;
        private TextView     tv_state;
        private LinearLayout ll_go;


        private GroupViewHolder(View view) {
            tv_time =  view.findViewById(R.id.tv_time);
            tv_state =  view.findViewById(R.id.tv_state);
            ll_go =  view.findViewById(R.id.ll_go);
        }
    }

    class ChildViewHolder{
        private ImageView    iv;
        private TextView     tv_name;
        private TextView     tv_price_and_num;

        private ChildViewHolder(View view) {
            iv =  view.findViewById(R.id.iv);
            tv_name =  view.findViewById(R.id.tv_name);
            tv_price_and_num =  view.findViewById(R.id.tv_price_and_num);

        }
    }


}
