package com.zszx.b2c.ui.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.zszx.b2c.R;


public class PeopleSetActivity extends AppCompatActivity {
    private ImageView    iv_back;
    private LinearLayout ll_img;
    private ImageView    iv_img;
    private LinearLayout ll_name;
    private TextView     tv_name;
    private LinearLayout ll_sex;
    private TextView     tv_sex;
    private LinearLayout ll_like;
    private TextView     tv_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_set);
        bindView();
        initData();

    }

    private void initData() {
        RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        Glide.with(this)
                .load(R.mipmap.zhanwei_classfy_food)
                .apply(mRequestOptions)
                .into(iv_img);
    }

    private void bindView() {

        iv_back = (ImageView) findViewById(R.id.iv_back);
        ll_img = (LinearLayout) findViewById(R.id.ll_img);
        iv_img = (ImageView) findViewById(R.id.iv_img);
        ll_name = (LinearLayout) findViewById(R.id.ll_name);
        tv_name = (TextView) findViewById(R.id.tv_name);
        ll_sex = (LinearLayout) findViewById(R.id.ll_sex);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        ll_like = (LinearLayout) findViewById(R.id.ll_like);
        tv_location = (TextView) findViewById(R.id.tv_location);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
