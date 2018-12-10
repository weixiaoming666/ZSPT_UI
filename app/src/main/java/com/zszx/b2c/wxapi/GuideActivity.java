package com.zszx.b2c.wxapi;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zszx.b2c.R;
import com.zszx.b2c.ui.CartFragment;
import com.zszx.b2c.ui.ClassifyFragment;
import com.zszx.b2c.ui.HomePageFragment;
import com.zszx.b2c.ui.MineFragment;
import com.zszx.b2c.ui.StoreFragment;
import com.zszx.b2c.ui.home.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

//引导页
public class GuideActivity extends AppCompatActivity {
    private ViewPager       vp;
    private List<Fragment>  list;
    private FragmentAdapter fragAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        vp = findViewById(R.id.vp);
        list = new ArrayList<Fragment>();
        list.add(new GuideFragment(1));
        list.add(new GuideFragment(2));
        list.add(new GuideFragment(3));
        fragAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(fragAdapter);
        vp.setCurrentItem(0);
    }
}
