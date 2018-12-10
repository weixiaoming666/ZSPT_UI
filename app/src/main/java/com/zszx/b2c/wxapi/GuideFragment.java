package com.zszx.b2c.wxapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zszx.b2c.LoginActivity;
import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;

@SuppressLint("ValidFragment")
public class GuideFragment  extends Fragment {
    View view;
    int type;

    public GuideFragment(int i) {
        super();
        type = i;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_guide, container, false);
           if (type==1){
                view.setBackgroundResource(R.drawable.guide_page_one);
           }else if (type == 2){
               view.setBackgroundResource(R.drawable.guide_page_two);
           }else {
               view.setBackgroundResource(R.drawable.guide_page_three);
               view.findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       startActivity(new Intent(getActivity(), LoginActivity.class));
                       getActivity().finish();
                   }
               });
           }
        }
        return view;
    }






}
