package com.zszx.b2c.ui.my;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.home.adapter.FoodDiscountsAdapter;
import com.zszx.b2c.ui.home.adapter.FragmentAdapter;
import com.zszx.b2c.ui.home.util.GlideImageLoader;
import com.zszx.b2c.ui.my.fragment.OldStoreFragmenThree;
import com.zszx.b2c.ui.my.fragment.OldStoreFragmentFour;
import com.zszx.b2c.ui.my.fragment.OldStoreFragmentOne;
import com.zszx.b2c.ui.my.fragment.OldStoreFragmentTwo;
import com.zszx.b2c.ui.my.fragment.ProductDetailsFragmentOne;
import com.zszx.b2c.ui.my.fragment.ProductDetailsFragmentThree;
import com.zszx.b2c.ui.my.fragment.ProductDetailsFragmentTwo;
import com.zszx.b2c.ui.news.NewShowListActivity;
import com.zszx.b2c.utils.ToastUtil;
import com.zszx.b2c.view.ChoseTypeProductDialog;
import com.zszx.b2c.view.ProductMarkDialog;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//商品详情
public class ProductDetailsActivity extends AppCompatActivity {
    private TextView                          tv_red_price;
    private TextView                          tv_grey_price;
    private TextView                          tv_title;
    private CheckBox                          cb_select;
    private LinearLayout                           ll_red_packet;
    private LinearLayout                           ll_guige;
    private TextView                               tv_name;
    private TextView                          tv_num;
    private Button                            bt_collect_store;
    private TextView                          tv_join_store;
    private RadioGroup                        rg;
    private RadioButton                       rb_1;
    private RadioButton                       rb_2;
    private RadioButton                       rb_3;
    private android.support.v4.view.ViewPager vp;
    private com.zszx.b2c.view.MyGradView      gv;
    private ImageView                         iv_back;
    private LinearLayout                      ll_classify;
    private LinearLayout                      ll_details;
    private LinearLayout                      ll_call;
    private Button                            bt_add_car;
    private Button                            bt_pay;
    private Banner                            banner_title;
    private Context                           mContext;
    private ProductMarkDialog                      mMarkDialog;
    private  Integer[] imgs_gv1  = {R.drawable.shopping_shangpin_xiangqing_benner_pic, R.drawable.shopping_shangpin_xiangqing_benner_pic, R.drawable.shopping_shangpin_xiangqing_benner_pic, R.drawable.shopping_shangpin_xiangqing_benner_pic, R.drawable.shopping_shangpin_xiangqing_benner_pic};
    private List<Fragment>  list;
    private FragmentAdapter fragAdapter;
    ChoseTypeProductDialog typeProductDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        mContext = this;
        bindViews();
        bindListener();
        initBinner();

    }

    private void initBinner() {
        banner_title.setBannerStyle(BannerConfig.CIRCLE_INDICATOR|BannerConfig.RIGHT);
        banner_title.setImageLoader(new GlideImageLoader());
        banner_title.setBannerAnimation(com.youth.banner.Transformer.DepthPage);
        banner_title.isAutoPlay(true);
        banner_title.setDelayTime(1500);
        banner_title.setIndicatorGravity(BannerConfig.RIGHT);
        banner_title.setImages(Arrays.asList(imgs_gv1));
        banner_title.start();
        banner_title.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
    }

    private void bindListener() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gv.setAdapter(new FoodDiscountsAdapter(mContext));
        bt_add_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMarkDialog == null){
                    mMarkDialog = new ProductMarkDialog(mContext);
                }
                mMarkDialog.show();
            }
        });
        bt_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(mContext,"去支付页面");
            }
        });
        cb_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ToastUtil.showShort(mContext,"收藏该食物");
                }else {
                    ToastUtil.showShort(mContext,"取消收藏");
                }
            }
        });
        ll_red_packet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(mContext,"获取红包，购物卷");
            }
        });
        ll_guige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typeProductDialog == null){
                    typeProductDialog = new ChoseTypeProductDialog(mContext);
                }
                
                typeProductDialog.show();
                ToastUtil.showShort(mContext,"选择规格参数");
            }
        });
        bt_collect_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(mContext,"收藏店铺");
            }
        });
        tv_join_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(mContext,"进入店铺");
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
                        break;
                    case 1:
                        rb_2.setChecked(true);
                        break;
                    case 2:
                        rb_3.setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void bindViews() {

        banner_title = (com.youth.banner.Banner) findViewById(R.id.banner_title);
        tv_red_price = (TextView) findViewById(R.id.tv_red_price);
        tv_grey_price = (TextView) findViewById(R.id.tv_grey_price);
        tv_title = (TextView) findViewById(R.id.tv_title);
        cb_select = (CheckBox) findViewById(R.id.cb_select);
        ll_red_packet = (LinearLayout) findViewById(R.id.ll_red_packet);
        ll_guige = (LinearLayout) findViewById(R.id.ll_guige);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_num = (TextView) findViewById(R.id.tv_num);
        bt_collect_store = (Button) findViewById(R.id.bt_collect_store);
        tv_join_store = (TextView) findViewById(R.id.tv_join_store);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        vp = (android.support.v4.view.ViewPager) findViewById(R.id.vp);
        gv = (com.zszx.b2c.view.MyGradView) findViewById(R.id.gv);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        ll_classify = (LinearLayout) findViewById(R.id.ll_classify);
        ll_details = (LinearLayout) findViewById(R.id.ll_details);
        ll_call = (LinearLayout) findViewById(R.id.ll_call);
        bt_add_car = (Button) findViewById(R.id.bt_add_car);
        bt_pay = (Button) findViewById(R.id.bt_pay);
        list = new ArrayList<Fragment>();
        list.add(new ProductDetailsFragmentOne());
        list.add(new ProductDetailsFragmentTwo());
        list.add(new ProductDetailsFragmentThree());
        fragAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(fragAdapter);
        vp.setCurrentItem(0);
    }
}
