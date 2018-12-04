package com.zszx.b2c.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.ui.classify.fragment.ClassfyTab1Fragment;
import com.zszx.b2c.ui.home.adapter.FragmentAdapter;
import com.zszx.b2c.ui.my.OldStoreMainActivity;

import java.util.ArrayList;
import java.util.List;

public class StoreFragment extends BaseFragment {
    View view;
    private SearchView   sv;
    private RadioGroup   rg;
    private RadioButton  rb_0;
    private RadioButton  rb_1;
    private RadioButton  rb_2;
    private RadioButton  rb_3;
    private RadioButton  rb_4;
    private RadioButton  rb_5;
    private RadioButton  rb_6;
    private RadioButton  rb_7;
    private RadioButton  rb_8;
    private RadioButton  rb_9;
    private LinearLayout ll_store_1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_zszx_store, container, false);
            bindView(view);
            setCallBack();
        }
        return view;
    }

    private void setCallBack() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_0:

                        break;
                    case R.id.rb_1:

                        break;
                    case R.id.rb_2:

                        break;
                    case R.id.rb_3:

                        break;
                    case R.id.rb_4:

                        break;
                    case R.id.rb_5:

                        break;
                    case R.id.rb_6:

                        break;
                    case R.id.rb_7:

                        break;
                    case R.id.rb_8:

                        break;
                    case R.id.rb_9:

                        break;
                }

            }
        });

    }

    private void bindView(View view) {
        sv = view.findViewById(R.id.sv);
        rg = (RadioGroup) view.findViewById(R.id.rg);
        rb_0 = (RadioButton) view.findViewById(R.id.rb_0);
        rb_1 = (RadioButton) view.findViewById(R.id.rb_1);
        rb_2 = (RadioButton) view.findViewById(R.id.rb_2);
        rb_3 = (RadioButton) view.findViewById(R.id.rb_3);
        rb_4 = (RadioButton) view.findViewById(R.id.rb_4);
        rb_5 = (RadioButton) view.findViewById(R.id.rb_5);
        rb_6 = (RadioButton) view.findViewById(R.id.rb_6);
        rb_7 = (RadioButton) view.findViewById(R.id.rb_7);
        rb_8 = (RadioButton) view.findViewById(R.id.rb_8);
        rb_9 = (RadioButton) view.findViewById(R.id.rb_9);
        ll_store_1 =  view.findViewById(R.id.ll_store_1);
        //获取到TextView的ID
        int id = sv.getContext().getResources().getIdentifier("android:id/search_src_text",null,null);
        //获取到TextView的控件
        SearchView.SearchAutoComplete textView =  sv.findViewById(R.id.search_src_text);
        //设置字体大小为14sp
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);//14sp
        sv.setIconifiedByDefault(false);
        sv.setSubmitButtonEnabled(true);

        ll_store_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OldStoreMainActivity.class));
            }
        });
    }

    @Override
    public View initView() {
        return null;
    }
    @Override
    public void initData() {

    }
}
