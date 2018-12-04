package com.zszx.b2c.ui.mine;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.mine.adapter.DisposeRefundAdapter;
import com.zszx.b2c.utils.ToastUtil;

public class RefundActivityThreeActivity extends AppCompatActivity {
    private ImageView iv_back;
    private TextView  tv_name;
    private TextView  tv_prace;
    private TextView  tv_time;
    private TextView  tv_reason;
    private TextView  tv_money;
    private ListView  lv;
    private Button    bt_jieru;
    private Button    bt_lianxi;
    private Context   context;
    // End Of Content View Elements




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund_three);
        context = this;
        bindViews();
        bindListener();
    }

    private void bindListener() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_jieru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"介入");
            }
        });
        bt_lianxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"联系店家");
            }
        });
        lv.setAdapter(new DisposeRefundAdapter(context));
    }

    private void bindViews() {

        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_prace = (TextView) findViewById(R.id.tv_prace);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_reason = (TextView) findViewById(R.id.tv_reason);
        tv_money = (TextView) findViewById(R.id.tv_money);
        lv = (ListView) findViewById(R.id.lv);
        bt_jieru = (Button) findViewById(R.id.bt_jieru);
        bt_lianxi = (Button) findViewById(R.id.bt_lianxi);
    }
}
