package com.zszx.b2c.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.MyListview;
import com.zszx.b2c.ui.mine.adapter.OrderElvDetiallsAdapter;
import com.zszx.b2c.ui.mine.adapter.RefundAdapter;
import com.zszx.b2c.view.MyExpandaleListView;

public class RefundActivity extends AppCompatActivity {
    private MyListview lv;
    private Context    mContext;
    private TextView   tv_refund;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_refund);
        bindView();
        bindListener();
    }

    private void bindListener() {
        lv.setAdapter(new RefundAdapter(mContext));
        tv_refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,RefundActivityTwoActivity.class));
            }
        });
    }

    private void bindView() {
      lv = findViewById(R.id.lv);
        tv_refund = findViewById(R.id.tv_refund);


    }
}
