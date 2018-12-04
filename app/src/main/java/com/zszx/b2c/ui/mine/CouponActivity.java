package com.zszx.b2c.ui.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.mine.adapter.CouponAdapter;

//中食券
public class CouponActivity extends AppCompatActivity {
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_activity);
        lv = findViewById(R.id.lv);
        lv.setAdapter(new CouponAdapter(CouponActivity.this));
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
