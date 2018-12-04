package com.zszx.b2c.ui.classify.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.home.adapter.FoodBuyShowAdapter;
import com.zszx.b2c.ui.home.adapter.FoodDiscountsAdapter;
import com.zszx.b2c.view.PopClassifySearchDialog;

public class ClassifySearchActivity extends AppCompatActivity {
    // Content View Elements
    PopClassifySearchDialog mPopClassifySearchDialog;
    private LinearLayout                         linearLayout;
    private ImageView                            iv_back;
    private android.support.v7.widget.SearchView sv;
    private RadioGroup                           rg;
    private RadioButton                          rb_1;
    private RadioButton                          rb_2;
    private RadioButton                          rb_3;
    private RadioGroup                           rg_price;
    private RadioButton                          rb_price_top;
    private RadioButton                          rb_price_down;
    private RadioButton                          rb_4;
    private LinearLayout                         ll_search;
    private GridView                             gv;
    private CheckBox                             cb_state_gv;

    // End Of Content View Elements



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_search);
        bindViews();
        bindListenter();
    }



    private void bindViews() {

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        sv = (android.support.v7.widget.SearchView) findViewById(R.id.sv);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        rg_price = (RadioGroup) findViewById(R.id.rg_price);
        rb_price_top = (RadioButton) findViewById(R.id.rb_price_top);
        rb_price_down = (RadioButton) findViewById(R.id.rb_price_down);
        rb_4 = (RadioButton) findViewById(R.id.rb_4);
        ll_search = (LinearLayout) findViewById(R.id.ll_search);
        gv = (GridView) findViewById(R.id.gv);
        cb_state_gv =  findViewById(R.id.cb_state_gv);
    }

    private void bindListenter() {
        gv.setAdapter(new FoodBuyShowAdapter(this));
        cb_state_gv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    gv.setNumColumns(2);
                    gv.setAdapter(new FoodDiscountsAdapter(ClassifySearchActivity.this));
                }else {
                    gv.setNumColumns(1);
                    gv.setAdapter(new FoodBuyShowAdapter(ClassifySearchActivity.this));
                }

            }
        });
        ll_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopClassifySearchDialog == null){
                    mPopClassifySearchDialog = new PopClassifySearchDialog(ClassifySearchActivity.this);
                }
                mPopClassifySearchDialog.showAtLocation(linearLayout, Gravity.RIGHT,0,0);
            }
        });

    }
}
