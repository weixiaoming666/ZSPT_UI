package com.zszx.b2c.ui.mine;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.home.adapter.FragmentAdapter;
import com.zszx.b2c.ui.mine.Fragment.OrderStateFragmentFivw;
import com.zszx.b2c.ui.mine.Fragment.OrderStateFragmentFour;
import com.zszx.b2c.ui.mine.Fragment.OrderStateFragmentOne;
import com.zszx.b2c.ui.mine.Fragment.OrderStateFragmentTwo;
import com.zszx.b2c.ui.mine.Fragment.OrderStateFragmentthree;

import java.util.ArrayList;
import java.util.List;

public class OrderStateActivity extends AppCompatActivity {
    private  int state_chose = 0;//0 代付款 1 代发货 2 3 待评价 4 售后
    private RadioGroup                        rg;
    private RadioButton                       rb_1;
    private RadioButton                       rb_2;
    private RadioButton                       rb_3;
    private RadioButton                       rb_4;
    private RadioButton                       rb_5;
    private TextView                          tv_title;
    private android.support.v4.view.ViewPager vp;
    private List<Fragment>                    list;
    private FragmentAdapter                   fragAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_state);
        state_chose = getIntent().getIntExtra("state",0);
        bindViews();
        bindListener();
        initDatas();
    }

    private void bindListener() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb_2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb_3:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rb_4:
                        vp.setCurrentItem(3);
                        break;
                        case R.id.rb_5:
                        vp.setCurrentItem(4);
                        break;
                }
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rb_1.setChecked(true);
                        tv_title.setText("待付款");
                        break;
                    case 1:
                        rb_2.setChecked(true);
                        tv_title.setText("待发货");

                        break;
                    case 2:
                        tv_title.setText("待收获");
                        rb_3.setChecked(true);
                        break;
                    case 3:
                        rb_4.setChecked(true);
                        tv_title.setText("待评价");
                        break;
                    case 4:
                        rb_5.setChecked(true);
                        tv_title.setText("售后");
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initDatas() {
        list = new ArrayList<Fragment>();
        list.add(new OrderStateFragmentOne());
        list.add(new OrderStateFragmentTwo());
        list.add(new OrderStateFragmentthree());
        list.add(new OrderStateFragmentFour());
        list.add(new OrderStateFragmentFivw());
        fragAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(fragAdapter);
        vp.setCurrentItem(state_chose);
    }
    // End Of Content View Elements

    private void bindViews() {

        tv_title =  findViewById(R.id.tv_title);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        rb_4 = (RadioButton) findViewById(R.id.rb_4);
        rb_5 = (RadioButton) findViewById(R.id.rb_5);
        vp = (android.support.v4.view.ViewPager) findViewById(R.id.vp);
    }

}
