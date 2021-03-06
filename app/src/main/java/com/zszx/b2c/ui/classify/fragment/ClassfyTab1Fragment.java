package com.zszx.b2c.ui.classify.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;


import com.bumptech.glide.Glide;
import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.entity.classify.ClassTitleBean;
import com.zszx.b2c.net.ConstantUtils;
import com.zszx.b2c.ui.ClassifyFragment;
import com.zszx.b2c.ui.HomePageFragment;
import com.zszx.b2c.ui.MyListview;
import com.zszx.b2c.ui.classify.adapter.RecAdapter;
import com.zszx.b2c.ui.classify.adapter.TitleMainAdapter;
import com.zszx.b2c.ui.home.adapter.FragmentAdapter;
import com.zszx.b2c.view.MyGradView;

import java.util.ArrayList;
import java.util.List;

//热门推介
public class ClassfyTab1Fragment extends BaseFragment {
    View       view;
    MyListview mlv;
    ImageView  iv;

    private ClassTitleBean.DataBeanX.BannerBean banner;
    List<ClassTitleBean.DataBeanX.RecBean> recList;
    public ClassfyTab1Fragment() {

    }

    @SuppressLint("ValidFragment")
    public ClassfyTab1Fragment(ClassTitleBean.DataBeanX.BannerBean banner, List<ClassTitleBean.DataBeanX.RecBean> recList) {
        this.banner = banner;
        this.recList = recList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_classufy_tab_1, container, false);
            bindView(view);
            setCallback();
            initData();
        }
        return view;
    }
    private void setCallback() {
        mlv.setAdapter(new RecAdapter(context,recList));
        Glide.with(context).load(ConstantUtils.base_url_host+banner.image).into(iv);
        }

    private void bindView(View view) {
        mlv = view.findViewById(R.id.mlv);
        iv = view.findViewById(R.id.iv);
    }

    @Override
    public View initView() {
        return null;
    }


}
