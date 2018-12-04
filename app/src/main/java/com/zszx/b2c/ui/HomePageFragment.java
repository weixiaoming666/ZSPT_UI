package com.zszx.b2c.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.ui.home.acyivity.SearchActivity;
import com.zszx.b2c.ui.home.adapter.FoodBuyShowAdapter;
import com.zszx.b2c.ui.home.adapter.FoodDiscountsAdapter;
import com.zszx.b2c.ui.home.adapter.GVadapter;
import com.zszx.b2c.ui.home.adapter.SpecialAdapter;
import com.zszx.b2c.ui.home.util.GlideImageLoader;
import com.zszx.b2c.ui.location.LocationActivity;
import com.zszx.b2c.ui.news.NewShowListActivity;
import com.zszx.b2c.utils.ToastUtil;
import com.zszx.b2c.view.MyGradView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by wxm on 2018/11/14.
 * 首页
 */
public class HomePageFragment extends BaseFragment {
    View view;
    List<String> title = new ArrayList<>()  ;
    private  Integer[] imgs     = {R.drawable.home_bnnenr_pic, R.drawable.home_bnnenr_pic, R.drawable.home_bnnenr_pic};
    private  String[]  titles   = {"666", "777", "888"};
    private  String[]  names_gv = {"进口食品", "休闲食品", "新鲜水果", "粮油调味", "鲜虾海鲜", "精选肉类", "蔬菜蛋类", "其它分类"};
    private  Integer[] imgs_gv  = {R.drawable.home_classification_uncertain_1, R.drawable.home_classification_uncertain_2, R.drawable.home_classification_uncertain_3, R.drawable.home_classification_uncertain_4, R.drawable.home_classification_uncertain_5,
            R.drawable.home_classification_uncertain_6, R.drawable.home_classification_uncertain_7, R.drawable.home_classification_uncertain_8};
    private  Integer[] imgs_gv1  = {R.drawable.bg_white, R.drawable.bg_white, R.drawable.bg_white, R.drawable.bg_white, R.drawable.bg_white, R.drawable.bg_white, R.drawable.bg_white, R.drawable.bg_white};

    private Banner     banner;
    private MyGradView gv;
    private Banner     banner_title;
    private LinearLayout ll_news ;
    private MyListview mlv_rm;
    private MyListview mlv_ts;
    private MyGradView gv_xpsj;
    private MyGradView gv_xsyh;
    private SearchView sv;//搜索框
    private ImageView  iv_location;//定位按钮
    private TextView   tv_location;//定位地址
    private int          TO_LOCATION = 88;
    private LinearLayout ll_store;
    private LinearLayout ll_store_index;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.activity_zszx_main, container, false);
            bindView(view);
            initBinner();
            setCallback();
        }
        return view;
    }

    private void setCallback() {
//        选取城市
        iv_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), LocationActivity.class),TO_LOCATION);
            }
        });
    }

    @Override
    public View initView() {
        return null;
    }

    private void bindView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        gv = view.findViewById(R.id.gv);
        banner_title = (Banner) view.findViewById(R.id.banner_title);
        ll_news = (LinearLayout) view.findViewById(R.id.ll_news);
        mlv_rm = view.findViewById(R.id.mlv_rm);
        mlv_ts = view.findViewById(R.id.mlv_ts);
        gv_xpsj = view.findViewById(R.id.gv_xpsj);
        gv_xsyh = view.findViewById(R.id.gv_xsyh);
        ll_store_index = view.findViewById(R.id.ll_store_index);//店铺6-5
        ll_store = view.findViewById(R.id.ll_store);//店铺6-1
        sv = view.findViewById(R.id.sv);
        //获取到TextView的ID
        int id = sv.getContext().getResources().getIdentifier("android:id/search_src_text",null,null);
    //获取到TextView的控件
        SearchView.SearchAutoComplete textView =  sv.findViewById(R.id.search_src_text);
    //设置字体大小为14sp
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);//14sp
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SearchActivity.class));
            }
        });
        iv_location = view.findViewById(R.id.iv_location);
        tv_location = view.findViewById(R.id.tv_location);
        sv.setIconifiedByDefault(false);
        sv.setSubmitButtonEnabled(true);
//        sv.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
//           @Override
//           public void onFocusChange(View v, boolean hasFocus) {
//               startActivity(new Intent(getActivity(),SearchActivity.class));
//           }
//       });

        ll_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(getActivity(),"新闻7-1");
            }
        });
        ll_store_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(getActivity(),"店铺6-5");
            }
        });
        ll_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(getActivity(),"店铺6-1");
            }
        });
    }
    private void initBinner() {
        title.addAll(Arrays.asList(titles));
        //设置banner样式
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImages(Arrays.asList(imgs));
        //设置banner动画效果
        banner.setBannerAnimation(com.youth.banner.Transformer.DepthPage);

        // 设置标题集合（当banner样式有显示title时）
//        banner_title.setBannerTitles(Arrays.asList(names_gv));
        //设置自动轮播，默认为true

        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner_title.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner_title.setImageLoader(new GlideImageLoader());
        banner_title.setBannerAnimation(com.youth.banner.Transformer.DepthPage);
        banner_title.isAutoPlay(true);
        banner_title.setDelayTime(1500);
        banner_title.setIndicatorGravity(BannerConfig.RIGHT);
        banner_title.setImages(Arrays.asList(imgs_gv1));
        banner_title.setBannerTitles(Arrays.asList(names_gv));
        banner_title.start();
        banner_title.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ToastUtil.showShort(getActivity(),"新闻7-"+position);
                startActivity(new Intent(getActivity(), NewShowListActivity.class));
            }
        });

        gv.setAdapter(new GVadapter(Arrays.asList(names_gv), Arrays.asList(imgs_gv),context));
        mlv_rm.setAdapter(new FoodBuyShowAdapter(context));
        gv_xsyh.setAdapter(new FoodDiscountsAdapter(context));
        mlv_ts.setAdapter(new SpecialAdapter(context));
        gv_xpsj.setAdapter(new FoodDiscountsAdapter(context));

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TO_LOCATION && resultCode == Activity.RESULT_OK){
            tv_location.setText(data.getStringExtra("info"));
        }
    }

}
