package com.zszx.b2c.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;

import com.zszx.b2c.R;
import com.zszx.b2c.ui.home.adapter.FoodBuyShowAdapter;
//购物车推介
public class ProductMarkDialog extends Dialog {
    private View    view;
    private Context context;
    public ProductMarkDialog(@NonNull Context context) {
        super(context);
        this.context = context;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow_product_mark);
//        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        int screenWidth = wm.getDefaultDisplay().getWidth();
//        final int screenHight = wm.getDefaultDisplay().getHeight();
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.width = screenWidth*4/5;
//        params.height = screenHight*3/5;
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCanceledOnTouchOutside(false);
        findViewById(R.id.iv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setBackgroundDrawableResource(android.R.color.white);
                dismiss();
            }
        });
        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(new FoodBuyShowAdapter(context));

    }
}
