package com.zszx.b2c.ui.mine;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.utils.ToastUtil;

public class PingjiaActivity extends AppCompatActivity {
    private ImageView iv_back;
    private ImageView iv_add;
    private TextView  tv_refund;
    private Context   context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_pingjia);
    }
    private void bindViews() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_add = (ImageView) findViewById(R.id.iv_add);
        tv_refund = (TextView) findViewById(R.id.tv_refund);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"评价提交成功");
                finish();
            }
        });
    }
}
