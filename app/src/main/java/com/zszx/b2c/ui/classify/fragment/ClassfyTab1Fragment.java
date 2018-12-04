package com.zszx.b2c.ui.classify.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.ui.ClassifyFragment;
import com.zszx.b2c.ui.HomePageFragment;
import com.zszx.b2c.ui.home.adapter.FragmentAdapter;
import com.zszx.b2c.view.MyGradView;

import java.util.ArrayList;

//热门推介
public class ClassfyTab1Fragment extends BaseFragment {
    View view;
    private MyGradView gv_food;
    private MyGradView gv_food_two;
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
        gv_food.setAdapter(new FoodAdapter());
        gv_food_two.setAdapter(new FoodAdapter());

        }

    private void bindView(View view) {
        gv_food = view.findViewById(R.id.gv_food);
        gv_food_two = view.findViewById(R.id.gv_food_two);


    }

    @Override
    public View initView() {
        return null;
    }
    class FoodAdapter extends  MyBaseAdapter{
        @Override
        public View getContenView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(context).inflate(R.layout.item_classfy,null);
            return view;
        }

        @Override
        public int getNum() {
            return 6;
        }
    }


}
