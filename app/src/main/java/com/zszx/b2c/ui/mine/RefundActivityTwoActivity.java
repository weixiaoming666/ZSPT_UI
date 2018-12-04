package com.zszx.b2c.ui.mine;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.utils.ToastUtil;

public class RefundActivityTwoActivity extends AppCompatActivity {

    private EditText    et;
    private ImageView   iv_add;
    private ImageView   iv_back;
    private RadioGroup  rg;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private TextView    tv_refund;
    private Context     context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund_two);
        context = this;
        bindView();
        bindListener();


    }

    private void bindListener() {
        tv_refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"申请成功");
                finish();
            }
        });
        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"添加照片");
                finish();
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void bindView() {
        et = (EditText) findViewById(R.id.et);
        iv_add = (ImageView) findViewById(R.id.iv_add);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        tv_refund = (TextView) findViewById(R.id.tv_refund);
        iv_back =  findViewById(R.id.iv_back);
    }
}
