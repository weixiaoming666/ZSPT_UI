package com.zszx.b2c.ui.mine.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;


import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.ui.mine.ExpressActivity;
import com.zszx.b2c.ui.mine.adapter.OrderStateThreeAdapter;
import com.zszx.b2c.utils.ToastUtil;

public class OrderStateFragmentthree extends BaseFragment {
    private View                   view;
    private ExpandableListView     elv;
    private OrderStateThreeAdapter mAdapter;
    private LinearLayout           ll_kuaidi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_state_three, container, false);
            bindView(view);
            setCallBack();
        }
        return view;
    }

    private void setCallBack() {
        ll_kuaidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(getActivity(),"快递详情");
                startActivity(new Intent(context,ExpressActivity.class));
            }
        });
    }

    private void bindView(View view) {
        elv = view.findViewById(R.id.elv);
        ll_kuaidi = view.findViewById(R.id.ll_kuaidi);
        elv.setAdapter(mAdapter = new OrderStateThreeAdapter(context));
        elv.setGroupIndicator(null);
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                mAdapter.mList.put(groupPosition,true);
                mAdapter.notifyDataSetChanged();
                return false;
            }
        });
        for(int i=0;i<3;i++){
            elv.expandGroup(i);
        }
    }

    @Override
    public View initView() {
        return null;
    }
}