package com.zszx.b2c.ui.home.acyivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.home.adapter.FoodBuyShowAdapter;
import com.zszx.b2c.ui.home.adapter.FoodConsultAdapter;
import com.zszx.b2c.ui.home.adapter.SpecialAdapter;
import com.zszx.b2c.view.MyGradView;

public class SearchShowActivity extends AppCompatActivity {
    private LinearLayout                         linearLayout;
    private ImageView                            iv_back;
    private android.support.v7.widget.SearchView sv;
    private RadioGroup                           rg;
    private RadioButton                          rb_1;
    private RadioButton                          rb_2;
    private RadioButton                          rb_3;
    private RadioButton                          rb_4;
    private TextView                             tv_shangpin;
    private MyGradView                             gv_sp;
    private TextView                             tv_zx;
    private MyGradView                             gv_zx;
    private TextView                             tv_sd;
    private MyGradView                           gv_sd;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_show);
        bindViews();
        bindListener();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getColor(R.color.calendar_selected_day_bg2));
        }

    }



    // End Of Content View Elements

    private void bindViews() {

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        sv = (android.support.v7.widget.SearchView) findViewById(R.id.sv);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        rb_4 = (RadioButton) findViewById(R.id.rb_4);
        tv_shangpin = (TextView) findViewById(R.id.tv_shangpin);
        gv_sp = (MyGradView) findViewById(R.id.gv_sp);
        tv_zx = (TextView) findViewById(R.id.tv_zx);
        gv_zx = (MyGradView) findViewById(R.id.gv_zx);
        tv_sd = (TextView) findViewById(R.id.tv_sd);
        gv_sd = (MyGradView) findViewById(R.id.gv_sd);
    }

    private void bindListener() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gv_sp .setAdapter(new FoodBuyShowAdapter(this));
        gv_zx.setAdapter(new FoodConsultAdapter(this));
        gv_sd.setAdapter(new SpecialAdapter(this));
    }


}
