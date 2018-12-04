package com.zszx.b2c.ui.my;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.CartFragment;
import com.zszx.b2c.ui.ClassifyFragment;
import com.zszx.b2c.ui.HomePageFragment;
import com.zszx.b2c.ui.MineFragment;
import com.zszx.b2c.ui.StoreFragment;
import com.zszx.b2c.ui.home.adapter.FragmentAdapter;
import com.zszx.b2c.ui.my.fragment.OldStoreFragmenThree;
import com.zszx.b2c.ui.my.fragment.OldStoreFragmentFour;
import com.zszx.b2c.ui.my.fragment.OldStoreFragmentOne;
import com.zszx.b2c.ui.my.fragment.OldStoreFragmentTwo;
import com.zszx.b2c.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

//店铺首页
public class OldStoreMainActivity extends AppCompatActivity {

    private LinearLayout                         linearLayout;
    private ImageView                            iv_back;
    private android.support.v7.widget.SearchView sv;
    private TextView                             tv_name;
    private TextView                             tv_num;
    private Button                               bt_collect;
    private RadioGroup                           rg;
    private RadioButton                          rb_1;
    private RadioButton                          rb_2;
    private RadioButton                          rb_3;
    private RadioButton                          rb_4;
    private LinearLayout                         ll_source;
    private android.support.v4.view.ViewPager    vp;
    private LinearLayout                         ll_classify;
    private LinearLayout                         ll_details;
    private LinearLayout                         ll_call;
    private Context                              context;
    private List<Fragment>                       list;
    private FragmentAdapter                      fragAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_store_main);
        context = this;
        bindViews();
        bindListener();
        initData();
    }

    private void initData() {
        list = new ArrayList<Fragment>();
        list.add(new OldStoreFragmentOne());
        list.add(new OldStoreFragmentTwo());
        list.add(new OldStoreFragmenThree());
        list.add(new OldStoreFragmentFour());
        fragAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(fragAdapter);
        vp.setCurrentItem(0);
    }

    private void bindListener() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"收藏");
            }
        });
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
                }
            }
        });
        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,OldStoreDetailActivity.class));
                ToastUtil.showShort(context,"店铺详情");
            }
        });
        ll_source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"溯源视频");
            }
        });
        ll_classify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"分类");
            }
        });

        ll_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"详情");
            }
        });

        ll_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"联系客服");
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
                        break;
                    case 1:
                        rb_2.setChecked(true);
                        break;
                    case 2:
                        rb_3.setChecked(true);
                        break;
                    case 3:
                        rb_4.setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // End Of Content View Elements

    private void bindViews() {
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        sv = (android.support.v7.widget.SearchView) findViewById(R.id.sv);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_num = (TextView) findViewById(R.id.tv_num);
        bt_collect = (Button) findViewById(R.id.bt_collect);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        rb_4 = (RadioButton) findViewById(R.id.rb_4);
        ll_source = (LinearLayout) findViewById(R.id.ll_source);
        vp = (android.support.v4.view.ViewPager) findViewById(R.id.vp);
        ll_classify = (LinearLayout) findViewById(R.id.ll_classify);
        ll_details = (LinearLayout) findViewById(R.id.ll_details);
        ll_call = (LinearLayout) findViewById(R.id.ll_call);
    }
}
