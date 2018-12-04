package com.zszx.b2c.ui.shoppingcart.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.home.adapter.FoodBuyShowAdapter;
import com.zszx.b2c.ui.home.adapter.FoodConsultAdapter;
import com.zszx.b2c.ui.home.adapter.FoodDiscountsAdapter;
import com.zszx.b2c.ui.location.QGridView;
import com.zszx.b2c.utils.ToastUtil;

//支付成功ok
public class PayActivity extends AppCompatActivity {

    private TextView  tv_success;
    private TextView  tv_money;
    private TextView  tv_num;
    private Button    bt_back;
    private Button    bt_look_order;
    private QGridView mlv;
    private Context   context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        context = this;
        bindViews();
        bindListener();
    }

    private void bindListener() {
        mlv.setAdapter(new FoodDiscountsAdapter(PayActivity.this));
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_look_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"查看订单");
            }
        });
    }

    private void bindViews() {
        tv_success = (TextView) findViewById(R.id.tv_success);
        tv_money = (TextView) findViewById(R.id.tv_money);
        tv_num = (TextView) findViewById(R.id.tv_num);
        bt_back = (Button) findViewById(R.id.bt_back);
        bt_look_order = (Button) findViewById(R.id.bt_look_order);
        mlv = findViewById(R.id.mlv);
       findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
    }

}
