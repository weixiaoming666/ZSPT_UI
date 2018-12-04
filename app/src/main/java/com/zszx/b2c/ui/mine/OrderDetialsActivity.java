package com.zszx.b2c.ui.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.mine.adapter.OrderElvDetiallsAdapter;
import com.zszx.b2c.ui.mine.adapter.OrderStateFourAdapter;
import com.zszx.b2c.ui.shoppingcart.adapter.OrderElvAdapter;
import com.zszx.b2c.utils.ToastUtil;
import com.zszx.b2c.view.MyExpandaleListView;

public class OrderDetialsActivity extends AppCompatActivity {
    private MyExpandaleListView     elv;
    private OrderElvDetiallsAdapter mAdapter;
    private TextView                tv_pingjia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detials);
        elv = findViewById(R.id.elv);
        elv.setAdapter(mAdapter = new OrderElvDetiallsAdapter(OrderDetialsActivity.this));
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

        tv_pingjia = findViewById(R.id.tv_pingjia);
        tv_pingjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetialsActivity.this,PingjiaActivity.class));
            }
        });
    }
}
