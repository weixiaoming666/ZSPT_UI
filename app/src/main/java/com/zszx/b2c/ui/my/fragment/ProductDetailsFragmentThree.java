package com.zszx.b2c.ui.my.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;

public class ProductDetailsFragmentThree extends BaseFragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_product_details_three, container, false);
            bindView(view);
            setCallBack();
        }
        return view;
    }

    private void setCallBack() {

    }

    private void bindView(View view) {

    }
    @Override
    public View initView() {
        return null;
    }
}