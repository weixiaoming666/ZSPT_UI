package com.zszx.b2c.ui.classify.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.entity.classify.ClassTitleBean;
import com.zszx.b2c.net.ConstantUtils;
import com.zszx.b2c.ui.classify.adapter.Food2Adapter;
import com.zszx.b2c.view.MyGradView;

import java.util.List;

public class ClassfyTab2Fragment extends BaseFragment {
    View       view;
    MyGradView gv_food;
    ImageView  iv;

    private ClassTitleBean.DataBeanX.BannerBean              banner;
    public List<ClassTitleBean.DataBeanX.DataBean.SunBeanX> mSunBeanX;
    public ClassfyTab2Fragment() {

    }

    @SuppressLint("ValidFragment")
    public ClassfyTab2Fragment(ClassTitleBean.DataBeanX.BannerBean banner,  List<ClassTitleBean.DataBeanX.DataBean.SunBeanX>  recList) {
        this.banner = banner;
        this.mSunBeanX = recList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_classufy_tab_2, container, false);
            bindView(view);
            setCallback();
            initData();
        }
        return view;
    }
    private void setCallback() {
        if (mSunBeanX != null){
            gv_food.setAdapter(new Food2Adapter(context,mSunBeanX));
        }else {

        }
        Glide.with(context).load(ConstantUtils.base_url_host+banner.image).into(iv);
    }

    private void bindView(View view) {
        gv_food = view.findViewById(R.id.gv_food);
        iv = view.findViewById(R.id.iv);
    }

    @Override
    public View initView() {
        return null;
    }


}
