package com.zszx.b2c.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupWindow;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.classify.adapter.ClassifySearchAdapter;
import com.zszx.b2c.utils.ToastUtil;

public class PopClassifySearchDialog extends PopupWindow {
    private final LayoutInflater mInflater;
    private       View           mView;
    private       Context        mContext;
    private MyGradView gv_brand;
    private MyGradView gv_address;
    private Button   bt_reset;
    private Button   bt_ok;


    public PopClassifySearchDialog(Context context) {
        super(context);
        this.mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mInflater.inflate(R.layout.popwindow_classify_search,null);
        //设置View
        bindViews();
        setContentView(mView);
        //设置宽与高
        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        setHeight(WindowManager.LayoutParams.MATCH_PARENT);
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

    private void bindViews() {

        gv_brand = (MyGradView) mView.findViewById(R.id.gv_brand);
        gv_address = (MyGradView) mView.findViewById(R.id.gv_address);
        bt_reset = (Button) mView.findViewById(R.id.bt_reset);
        bt_ok = (Button) mView.findViewById(R.id.bt_ok);

        gv_brand.setAdapter(new ClassifySearchAdapter(mContext));
        gv_address.setAdapter(new ClassifySearchAdapter(mContext));
        bt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                ToastUtil.showShort(mContext,"reset");
            }
        });

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                ToastUtil.showShort(mContext,"ok");
            }
        });
    }



}
