package com.zszx.b2c.ui.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
//资讯列表

import com.zszx.b2c.R;
import com.zszx.b2c.ui.home.adapter.FoodConsultAdapter;

public class NewShowListActivity extends AppCompatActivity {
// Content View Elements

    private LinearLayout                         linearLayout;
    private ImageView                            iv_back;
    private android.support.v7.widget.SearchView sv;
    private RadioGroup                           rg;
    private RadioButton                          rb_1;
    private RadioButton                          rb_2;
    private RadioButton                          rb_3;
    private RadioButton                          rb_4;
    private RadioButton                          rb_5;
    private RadioButton                          rb_6;
    private GridView                             gv;

    // End Of Content View Elements




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_show_list);
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
    }

    private void bindViews() {

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        sv = (android.support.v7.widget.SearchView) findViewById(R.id.sv);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        rb_4 = (RadioButton) findViewById(R.id.rb_4);
        rb_5 = (RadioButton) findViewById(R.id.rb_5);
        rb_6 = (RadioButton) findViewById(R.id.rb_6);
        gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(new FoodConsultAdapter(this));
    }
}
