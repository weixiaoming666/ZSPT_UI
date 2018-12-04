package com.zszx.b2c.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.classify.adapter.ClassifySearchAdapter;
import com.zszx.b2c.ui.home.adapter.FoodBuyShowAdapter;
import com.zszx.b2c.utils.ToastUtil;

public class ChoseTypeProductDialog  extends Dialog {
    private View     view;
    private Context  context;
    private TextView tv_num;
    private GridView gv;
    public ChoseTypeProductDialog(@NonNull Context context) {
        super(context);
        this.context = context;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow_chose_type_product);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int screenWidth = wm.getDefaultDisplay().getWidth();
        final int screenHight = wm.getDefaultDisplay().getHeight();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = screenWidth;
        params.height = screenHight*49/50;

        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCanceledOnTouchOutside(false);
        tv_num = findViewById(R.id.tv_num);
        gv = findViewById(R.id.gv);
        bindListener();

    }

    private void bindListener() {
        findViewById(R.id.iv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setBackgroundDrawableResource(android.R.color.white);
                dismiss();
            }
        });

        findViewById(R.id.bt_add_car).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"添加到购物车");
            }
        });
        findViewById(R.id.bt_pay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"立即支付");
            }
        });
        findViewById(R.id.iv_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i  = Integer.parseInt(tv_num.getText().toString());
                tv_num.setText(i+1+"");
            }
        });
        findViewById(R.id.iv_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i  = Integer.parseInt(tv_num.getText().toString());
                if (i == 1){
                    ToastUtil.showShort(context,"数量不能为空");
                    return;
                }
                tv_num.setText(i-1+"");
            }
        });

        gv.setAdapter(new ClassifySearchAdapter(context) );
    }
}
