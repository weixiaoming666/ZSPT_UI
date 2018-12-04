package com.zszx.b2c.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.shoppingcart.activity.EditAddressActivity;
import com.zszx.b2c.utils.ToastUtil;

public class SetActivity extends AppCompatActivity {
// Content View Elements

    private LinearLayout                           ll_address;
    private LinearLayout                           ll_people_details;
    private LinearLayout                           ll_phone;
    private LinearLayout                           ll_message_push;
    private android.support.v7.widget.SwitchCompat switch_compat;
    private LinearLayout                           ll_del_cache;
    private LinearLayout                           ll_appraise;
    private LinearLayout                           ll_about_our;
    private LinearLayout                           ll_call_me;
    private Button                                 bt_back;
    private Context    context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        context = this;
        bindViews();
        bindListener();
    }

    private void bindListener() {
        ll_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"编辑地址");
                startActivity(new Intent(context, EditAddressActivity.class));
            }
        });
        ll_people_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,PeopleSetActivity.class));
                ToastUtil.showShort(context,"个人信息");
            }
        });
        ll_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"修改电话");
            }
        });
        ll_del_cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"清除缓存");
            }
        });
        ll_about_our.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"关于我们");
            }
        });
        ll_call_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"打给我");
            }
        });
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"退出登录");
            }
        });
        switch_compat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ToastUtil.showShort(context,"打开消息推送");
                }else {
                    ToastUtil.showShort(context,"关闭消息推送");
                }
            }
        });
    }


    // End Of Content View Elements

    private void bindViews() {
        ll_address = (LinearLayout) findViewById(R.id.ll_address);
        ll_people_details = (LinearLayout) findViewById(R.id.ll_people_details);
        ll_phone = (LinearLayout) findViewById(R.id.ll_phone);
        ll_message_push = (LinearLayout) findViewById(R.id.ll_message_push);
        switch_compat = (android.support.v7.widget.SwitchCompat) findViewById(R.id.switch_compat);
        ll_del_cache = (LinearLayout) findViewById(R.id.ll_del_cache);
        ll_appraise = (LinearLayout) findViewById(R.id.ll_appraise);
        ll_about_our = (LinearLayout) findViewById(R.id.ll_about_our);
        ll_call_me = (LinearLayout) findViewById(R.id.ll_call_me);
        bt_back = (Button) findViewById(R.id.bt_back);
    }


}
