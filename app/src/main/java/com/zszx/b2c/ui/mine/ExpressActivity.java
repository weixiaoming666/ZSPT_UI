package com.zszx.b2c.ui.mine;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.mine.adapter.ExpressAdapter;

//快递
public class ExpressActivity extends AppCompatActivity {
    private ListView lv;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express);
        mContext = this;
        bindView();

    }

    private void bindView() {
        lv = findViewById(R.id.lv);
        lv.setAdapter(new ExpressAdapter(mContext));
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
