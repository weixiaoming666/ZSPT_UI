package com.zszx.b2c.ui.shoppingcart.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.shoppingcart.adapter.OrderElvAdapter;
import com.zszx.b2c.view.MyExpandaleListView;

public class OrderActivity extends AppCompatActivity {
    private MyExpandaleListView elv;
    private OrderElvAdapter     mAdapter;
    private LinearLayout        ll_address;
    private Button              bt_pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        bindView();
        bindListener();
    }

    private void bindListener() {
        ll_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderActivity.this,EditAddressActivity.class));
            }
        });
        bt_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderActivity.this,PayActivity.class));
            }
        });

        elv.setAdapter(mAdapter = new OrderElvAdapter(OrderActivity.this));
        elv.setGroupIndicator(null);
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                mAdapter.mList.put(groupPosition,true);
                mAdapter.notifyDataSetChanged();
                return true;
            }
        });
        for(int i=0;i<3;i++){
            elv.expandGroup(i);
        }

    }
    private void bindView() {
        elv = findViewById(R.id.elv);
        ll_address = findViewById(R.id.ll_address);
        bt_pay = findViewById(R.id.bt_pay);
    }
}
