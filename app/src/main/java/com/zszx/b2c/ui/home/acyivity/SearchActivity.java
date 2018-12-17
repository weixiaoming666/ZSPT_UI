package com.zszx.b2c.ui.home.acyivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;


import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.zszx.b2c.R;
import com.zszx.b2c.base.MyBaseAdapter;
import com.zszx.b2c.entity.classify.ClassTitleBean;
import com.zszx.b2c.entity.home.HotSearchEntity;
import com.zszx.b2c.net.ContractNet;
import com.zszx.b2c.net.MyCallBack;
import com.zszx.b2c.utils.SpUtill;
import com.zszx.b2c.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private GridView gv_history,gv_hot;
    private LayoutInflater mInflater;
    private Context        mContext;
    private   List<String>   host = new ArrayList<>();
    private   List<String>   history = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mInflater = LayoutInflater.from(this);
        mContext = this;
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getColor(R.color.calendar_selected_day_bg2));
        }
        bindView();
        net();

    }

    private void net() {

        RequestParams params = new RequestParams();
        params.addQueryStringParameter("user_id", SpUtill.getInstance(mContext).getString(SpUtill.USER_ID,""));
        ContractNet.INSTANCE.hotSearch(params, new MyCallBack<HotSearchEntity>() {
            @Override
            public void onMySucess(HotSearchEntity entity) {
                initData(entity);
            }
            @Override
            public void onMyFail(HttpException e, String s) {
                ToastUtil.showShort(mContext,s);
            }
        },mContext);


    }

    private void initData(HotSearchEntity entity) {

        if (  entity.data.host!=null&&entity.data.host.size()>0){
            host.clear();
            host.addAll(entity.data.host) ;
        }
        if (  entity.data.history!=null&&entity.data.history.size()>0){
            history.clear();
            history.addAll(entity.data.history) ;
        }

        gv_history.setAdapter(new MyBaseAdapter() {
            @Override
            public View getContenView(int i, View view, ViewGroup viewGroup) {
                view = mInflater.inflate(R.layout.item_search,null);
                Button button = (Button) view;
                button.setText(history.get(i));
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(SearchActivity.this,SearchShowActivity.class));
                        ToastUtil.showShort(SearchActivity.this,"搜索");
                        finish();
                    }
                });
                return view;
            }

            @Override
            public int getNum() {
                return history.size();
            }
        });
        gv_hot.setAdapter(new MyBaseAdapter() {
            @Override
            public View getContenView(int i, View view, ViewGroup viewGroup) {
                view = mInflater.inflate(R.layout.item_search,null);
                Button button = (Button) view;
                button.setText(host.get(i));
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showShort(SearchActivity.this,"搜索");
                    }
                });
                return view;
            }

            @Override
            public int getNum() {
                return host.size();
            }
        });
    }

    private void bindView() {
        gv_history = findViewById(R.id.gv_history);
        gv_hot = findViewById(R.id.gv_hot);
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
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
