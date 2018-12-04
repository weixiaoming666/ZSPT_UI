package com.zszx.b2c.ui.my.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.ui.home.adapter.FoodDiscountsAdapter;
import com.zszx.b2c.view.MyGradView;

//首页
public class OldStoreFragmentOne extends BaseFragment{
    private View       view;
    private MyGradView gv_xpsj;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_old_store_one, container, false);
            bindView(view);
            setCallBack();
        }
        return view;
    }

    private void setCallBack() {
        gv_xpsj.setAdapter(new FoodDiscountsAdapter(context));
    }

    private void bindView(View view) {
        gv_xpsj = view.findViewById(R.id.gv_xpsj);
    }

    @Override
    public View initView() {
        return null;
    }
}
