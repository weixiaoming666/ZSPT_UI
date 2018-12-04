package com.zszx.b2c.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.ui.shoppingcart.adapter.ElvCarAdapter;
import com.zszx.b2c.ui.shoppingcart.activity.OrderActivity;

public class CartFragment extends BaseFragment {
    private View               view;
    private ExpandableListView elv;
    private ElvCarAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_zszx_cart, container, false);
            bindView(view);
            setCallBack();
        }
        return view;
    }

    private void setCallBack() {
            elv.setAdapter(mAdapter = new ElvCarAdapter(context));
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

        view.findViewById(R.id.bt_pay_money).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OrderActivity.class));
            }
        });

    }

    private void bindView(View view) {
        elv = view.findViewById(R.id.elv);
    }

    @Override
    public View initView() {
        return null;
    }
}
