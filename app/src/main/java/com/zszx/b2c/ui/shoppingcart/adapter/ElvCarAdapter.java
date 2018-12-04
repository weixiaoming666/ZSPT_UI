package com.zszx.b2c.ui.shoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.utils.ToastUtil;
import java.util.HashMap;
import java.util.Map;
public class ElvCarAdapter extends BaseExpandableListAdapter {
    public Map<Integer,Boolean> mList = new HashMap<>();
    private boolean  checked = false;
    private Context mContext;
    private LayoutInflater mInflater;
    public ElvCarAdapter(Context context) {
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
            convertView = mInflater.inflate(R.layout.item_car_group,null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        if (mList.get(groupPosition).booleanValue()){
            checked = true;
            groupViewHolder.cb.setChecked(true);
        }else {
            checked = true;
            groupViewHolder.cb.setChecked(false);
        }
        groupViewHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checked)return;
                mList.put(groupPosition,isChecked);
                notifyDataSetChanged();
            }
        });
        checked = false;
        return convertView;
    }
// 获取子view
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ChildViewHolder childViewHolder;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.item_car_child,null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        }else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int i  = Integer.parseInt(childViewHolder.tv_num.getText().toString());
                childViewHolder.tv_num.setText(i+1+"");
            }
        });
        childViewHolder.iv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i  = Integer.parseInt(childViewHolder.tv_num.getText().toString());
                if (i == 1){
                    ToastUtil.showShort(mContext,"数量不能为空");
                    return;
                }
                childViewHolder.tv_num.setText(i-1+"");
            }
        });
        if (mList.get(groupPosition).booleanValue()){
            childViewHolder.cb.setChecked(true);
        }else {
            childViewHolder.cb.setChecked(false);
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
            cb =  view.findViewById(R.id.cb);
            tv_name =  view.findViewById(R.id.tv_name);
            tv_manager =  view.findViewById(R.id.tv_manager);
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
