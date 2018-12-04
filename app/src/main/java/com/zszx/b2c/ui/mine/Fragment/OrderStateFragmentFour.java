package com.zszx.b2c.ui.mine.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.ui.mine.adapter.OrderStateFourAdapter;
import com.zszx.b2c.ui.mine.adapter.OrderStateOneAdapter;

public class OrderStateFragmentFour extends BaseFragment {
    private View                  view;
    private ExpandableListView    elv;
    private OrderStateFourAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_state_four, container, false);
            bindView(view);
            setCallBack();
        }
        return view;
    }

    private void setCallBack() {

    }

    private void bindView(View view) {
        elv = view.findViewById(R.id.elv);
        elv.setAdapter(mAdapter = new OrderStateFourAdapter(context));
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