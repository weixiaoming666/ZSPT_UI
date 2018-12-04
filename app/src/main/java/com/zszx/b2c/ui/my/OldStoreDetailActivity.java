package com.zszx.b2c.ui.my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.zszx.b2c.R;
import com.zszx.b2c.ui.my.adapter.ImgShowAdapter;
import com.zszx.b2c.ui.my.adapter.TvNumShowAdapter;
import com.zszx.b2c.ui.my.bean.TvNumBean;
import com.zszx.b2c.view.MyGradView;

import java.util.ArrayList;
import java.util.List;

//店铺详情页面
public class OldStoreDetailActivity extends AppCompatActivity {
    MyGradView gv;
    MyGradView gv_img_show;
    ImageView  iv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_store_detail);
        bindView();
        setLinstener();

    }

    private void setLinstener() {
        List<TvNumBean> datas = new ArrayList<>();
        datas.add(new TvNumBean("商品",55));
        datas.add(new TvNumBean("新品",8));
        datas.add(new TvNumBean("促销",12));
        datas.add(new TvNumBean("人购买",1234));
        gv.setAdapter(new TvNumShowAdapter(datas,this));
        List<String> imags = new ArrayList<>();
        imags.add("1");
        imags.add("1");
        imags.add("1");
        gv_img_show.setAdapter(new ImgShowAdapter(imags,this));
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void bindView() {
        gv = findViewById(R.id.gv);
        gv_img_show = findViewById(R.id.gv_img_show);
        iv_back = findViewById(R.id.iv_back);

    }
}
