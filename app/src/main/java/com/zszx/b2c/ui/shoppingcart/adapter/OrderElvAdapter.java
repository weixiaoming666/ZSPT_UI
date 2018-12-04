package com.zszx.b2c.ui.shoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.zszx.b2c.R;

import java.util.HashMap;
import java.util.Map;

public class OrderElvAdapter extends BaseExpandableListAdapter {
    public  Map<Integer,Boolean> mList   = new HashMap<>();
    private boolean              checked = false;
    private Context        mContext;
    private LayoutInflater mInflater;
    public OrderElvAdapter(Context context) {
        mContext = context;
        this.mInflater =LayoutInflater.from(mContext);
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
            convertView = mInflater.inflate(R.layout.item_car_group,null);
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
        ChildViewHolder childViewHolder;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.item_car_child,null);
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
        private TextView tv_location;
        private TextView tv_name;
        private TextView tv_manager;
        private CheckBox cb;

        private GroupViewHolder(View view) {
            tv_location =  view.findViewById(R.id.tv_location);
            view.findViewById(R.id.cb).setVisibility(View.GONE);
            tv_name =  view.findViewById(R.id.tv_name);
            view.findViewById(R.id.tv_manager).setVisibility(View.GONE);
        }
    }

    class ChildViewHolder{
        private CheckBox  cb;
        private TextView  tv_name;
        private TextView  iv_prace1;
        private TextView  tv_prace2;
        private TextView  tv_describe;
        private TextView  tv_num;
        private ImageView iv_del;
        private ImageView iv_add;

        private ChildViewHolder(View view) {
            view.findViewById(R.id.cb).setVisibility(View.GONE);
            tv_name =  view.findViewById(R.id.tv_name);
            iv_prace1 =  view.findViewById(R.id.iv_prace1);
            tv_prace2 =  view.findViewById(R.id.tv_prace2);
            tv_describe =  view.findViewById(R.id.tv_describe);
             view.findViewById(R.id.iv_del).setVisibility(View.GONE);
           view.findViewById(R.id.iv_add).setVisibility(View.GONE);
            view.findViewById(R.id.tv_num).setVisibility(View.GONE);

        }
    }


}

