package com.zszx.b2c.ui.shoppingcart.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.shoppingcart.adapter.EditAddressAdapter;
import com.zszx.b2c.utils.ToastUtil;

//订单
//订单
public class EditAddressActivity extends AppCompatActivity {
    private ListView lv;
    private Button   bt_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);
        bindView();
        bindListener();
    }

    private void bindListener() {
        lv.setAdapter(new EditAddressAdapter(EditAddressActivity.this));
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditAddressActivity.this,AddAddressActivity.class));
                ToastUtil.showShort(EditAddressActivity.this,"添加地址");
            }
        });
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void bindView() {
        lv = findViewById(R.id.lv);
        bt_add = findViewById(R.id.bt_add);
    }
}
