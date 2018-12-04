package com.zszx.b2c.ui.shoppingcart.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.lljjcoder.citypickerview.widget.CityPicker;
import com.zszx.b2c.R;

public class AddAddressActivity extends AppCompatActivity {
    private CityPicker                             cityPicker;
    private Context                                context;
    private EditText                               et_name;
    private EditText                               et_phone;
    private TextView                               tv_address_chose;
    private EditText                               et_address_detail;
    private android.support.v7.widget.SwitchCompat switch_compat;
    private Button                                 bt_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        context = this;
        bindView();
        bindListener();
    }

    private void bindListener() {
        tv_address_chose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityPicker.show();
            }
        });
    }

    private void bindView() {

        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        tv_address_chose = (TextView) findViewById(R.id.tv_address_chose);
        et_address_detail = (EditText) findViewById(R.id.et_address_detail);
        switch_compat = (android.support.v7.widget.SwitchCompat) findViewById(R.id.switch_compat);
        bt_ok = (Button) findViewById(R.id.bt_ok);
          //滚轮文字的大小
        //滚轮文字的颜色
         //省份滚轮是否循环显示
        //城市滚轮是否循环显示
        //地区（县）滚轮是否循环显示
        //滚轮显示的item个数
        //滚轮item间距
        cityPicker = new CityPicker.Builder(context)
        .textSize(20)//滚轮文字的大小
         .title("地址选择")
         .backgroundPop(0xa0000000)
        .titleBackgroundColor("#0CB6CA")
        .titleTextColor("#000000")
        .backgroundPop(0xa0000000)
         .confirTextColor("#000000")
        .cancelTextColor("#000000")
        .province("xx省")
        .city("xx市")
        .district("xx区")
        .textColor(Color.parseColor("#000000"))//滚轮文字的颜色
         .provinceCyclic(true)//省份滚轮是否循环显示
         .cityCyclic(false)//城市滚轮是否循环显示
         .districtCyclic(false)//地区（县）滚轮是否循环显示
        .visibleItemsCount(7)//滚轮显示的item个数
        .itemPadding(10)//滚轮item间距
        .onlyShowProvinceAndCity(false)
                .build();
        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
        @Override
        public void onSelected(String... citySelected) {
        //省份
        String province = citySelected[0];
        //城市
         String city = citySelected[1];
        //区县（如果设定了两级联动，那么该项返回空）
         String district = citySelected[2];
        //邮编
         String code = citySelected[3];
            tv_address_chose.setText(province + city + district);

        }

        @Override
        public void onCancel() {

        }
});

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
