package com.zszx.b2c.ui.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.ui.mine.adapter.JiFenShowAdapter;

//积分
public class IntegralActivity extends AppCompatActivity {

    private TextView tv_num;
    private ListView lv;

    // End Of Content View Elements


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral);
        bindViews();
        bindListener();
    }

    private void bindListener() {
        lv.setAdapter(new JiFenShowAdapter(IntegralActivity.this));
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void bindViews() {

        tv_num = (TextView) findViewById(R.id.tv_num);
        lv = (ListView) findViewById(R.id.lv);
    }


}
