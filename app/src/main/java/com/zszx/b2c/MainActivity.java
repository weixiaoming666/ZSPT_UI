package com.zszx.b2c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zszx.b2c.ui.CartFragment;
import com.zszx.b2c.ui.ClassifyFragment;
import com.zszx.b2c.ui.HomePageFragment;
import com.zszx.b2c.ui.MineFragment;
import com.zszx.b2c.ui.StoreFragment;
import com.zszx.b2c.ui.home.adapter.FragmentAdapter;
import com.zszx.b2c.view.RedPacketDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity  extends AppCompatActivity {
    private android.support.v4.view.ViewPager vp;
    private RadioGroup                        rg;
    private RadioButton                       rb_1;
    private RadioButton                       rb_2;
    private RadioButton                       rb_3;
    private RadioButton                       rb_4;
    private RadioButton                       rb_5;
    private List<Fragment>                    list;
    private FragmentAdapter                   fragAdapter;
    private RedPacketDialog                   mRedPacketDialog;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideBottomUIMenu();
        bindViews();
        bindListener();
        initData();
    }

    private void initData() {
        list = new ArrayList<Fragment>();
        list.add(new HomePageFragment());
        list.add(new ClassifyFragment());
        list.add(new StoreFragment());
        list.add(new CartFragment());
        list.add(new MineFragment());
        fragAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(fragAdapter);
        vp.setCurrentItem(0);
//        showRedpop();//红包弹出页面
    }

    private void showRedpop() {
        if (mRedPacketDialog == null){
            mRedPacketDialog = new RedPacketDialog(this);
        }
        mRedPacketDialog.show();
    }

    private void bindListener() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb_2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb_3:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rb_4:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.rb_5:
                        vp.setCurrentItem(4);
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
                    case 0:
                        rb_1.setChecked(true);
                        break;
                    case 1:
                        rb_2.setChecked(true);
                        break;
                    case 2:
                        rb_3.setChecked(true);
                        break;
                    case 3:
                        rb_4.setChecked(true);
                        break;
                    case 4:
                        rb_5.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void bindViews() {
        vp = (android.support.v4.view.ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        rb_4 = (RadioButton) findViewById(R.id.rb_4);
        rb_5 = (RadioButton) findViewById(R.id.rb_5);
    }
    /**
     * 隐藏虚拟按键，并且全屏
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    protected void hideBottomUIMenu() {
//        //隐藏虚拟按键，并且全屏
//        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
//            View v = this.getWindow().getDecorView();
//            v.setSystemUiVisibility(View.GONE);
//        } else if (Build.VERSION.SDK_INT >= 19) {
//            //for new api versions.
//            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//        }

        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);

//            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(getColor(R.color.calendar_selected_day_bg2));


        }

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v != null ? v.getWindowToken() : null, 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了  
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    public  boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = { 0, 0 };
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
