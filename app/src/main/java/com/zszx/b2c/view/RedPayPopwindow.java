package com.zszx.b2c.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.zszx.b2c.R;


public class RedPayPopwindow extends PopupWindow {
    private final LayoutInflater mInflater;
    private       View           mView;
    private       Context        mContext;

    public RedPayPopwindow(Context context) {
        super(context);
        this.mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mInflater.inflate(R.layout.popwindow_red_pay,null);
        //设置View
        setContentView(mView);
        //设置宽与高
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        /**
         * 设置进出动画
         */
        setAnimationStyle(R.style.MyPopupWindow);
//        /**
//         * 设置背景只有设置了这个才可以点击外边和BACK消失
//         */
//        setBackgroundDrawable(new ColorDrawable());


//        /**
//         * 设置可以获取集点       点击外部消失  默认支持   不需要下面的操作设置
//         */
//        setFocusable(true);
//
//        /**
//         * 设置点击外边可以消失
//         */
//        setOutsideTouchable(false);//不需要就可以
//
//        /**
//         *设置可以触摸
//         */
//        setTouchable(true);

    }
}