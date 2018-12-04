package com.zszx.b2c.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.ui.classify.fragment.ClassfyTab1Fragment;
import com.zszx.b2c.ui.home.acyivity.SearchActivity;
import com.zszx.b2c.ui.home.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxm on 2018/11/14.
 * 分类页面
 */
public class ClassifyFragment extends BaseFragment {
    View view;
    private SearchView      sv;
    private List<Fragment>  list;
    private FragmentAdapter fragAdapter;
    private ViewPager       vp;
    private RadioGroup      rg;
    private RadioButton     rb_0;
    private RadioButton     rb_1;
    private RadioButton     rb_2;
    private RadioButton     rb_3;
    private RadioButton     rb_4;
    private RadioButton     rb_5;
    private RadioButton     rb_6;
    private RadioButton     rb_7;
    private RadioButton     rb_8;
    private RadioButton     rb_9;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_zszx_classify, container, false);
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
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb_1:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb_2:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rb_3:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.rb_4:
                        vp.setCurrentItem(4);
                        break;
                    case R.id.rb_5:
                        vp.setCurrentItem(5);
                        break;
                    case R.id.rb_6:
                        vp.setCurrentItem(6);
                        break;
                    case R.id.rb_7:
                        vp.setCurrentItem(7);
                        break;
                    case R.id.rb_8:
                        vp.setCurrentItem(8);
                        break;
                    case R.id.rb_9:
                        vp.setCurrentItem(9);
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
                    case 1:
                        rb_1.setChecked(true);
                        break;
                    case 2:
                        rb_2.setChecked(true);
                        break;
                    case 3:
                        rb_3.setChecked(true);
                        break;
                    case 4:
                        rb_4.setChecked(true);
                        break;
                    case 5:
                        rb_5.setChecked(true);
                        break;
                    case 0:
                        rb_0.setChecked(true);
                        break;
                    case 6:
                        rb_6.setChecked(true);
                        break;
                    case 7:
                        rb_7.setChecked(true);
                        break;
                    case 8:
                        rb_8.setChecked(true);
                        break;
                    case 9:
                        rb_9.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void bindView(View view) {
        sv = view.findViewById(R.id.sv);
        vp = view.findViewById(R.id.vp);
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
        sv.setIconifiedByDefault(false);
        sv.setSubmitButtonEnabled(true);
//       sv.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
//           @Override
//           public void onFocusChange(View v, boolean hasFocus) {
//               startActivity(new Intent(getActivity(),SearchActivity.class));
//           }
//       });

    }

    @Override
    public View initView() {
        return null;
    }
    @Override
    public void initData() {
        list = new ArrayList<Fragment>();
        list.add(new ClassfyTab1Fragment());
        list.add(new ClassfyTab1Fragment());
        list.add(new ClassfyTab1Fragment());
        list.add(new ClassfyTab1Fragment());
        list.add(new ClassfyTab1Fragment());
        list.add(new ClassfyTab1Fragment());
        list.add(new ClassfyTab1Fragment());
        list.add(new ClassfyTab1Fragment());
        list.add(new ClassfyTab1Fragment());
        list.add(new ClassfyTab1Fragment());
        fragAdapter = new FragmentAdapter(getChildFragmentManager(), list);
        vp.setAdapter(fragAdapter);
        vp.setCurrentItem(0);
    }
}
