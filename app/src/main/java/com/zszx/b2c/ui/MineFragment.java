package com.zszx.b2c.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.ui.home.adapter.FoodBuyShowAdapter;
import com.zszx.b2c.ui.home.adapter.FoodDiscountsAdapter;
import com.zszx.b2c.ui.mine.CouponActivity;
import com.zszx.b2c.ui.mine.IntegralActivity;
import com.zszx.b2c.ui.mine.OrderStateActivity;
import com.zszx.b2c.ui.mine.SetActivity;
import com.zszx.b2c.utils.ToastUtil;
import com.zszx.b2c.view.MyGradView;

public class MineFragment extends BaseFragment {
    private View         view;
    private MyGradView   gv;
    private ImageView    iv;
    private ImageView    iv_set;
    private LinearLayout ll_jifen;
    private LinearLayout ll_youhuijuan;

    private FrameLayout ll_base_title;
    private LinearLayout ll_more;
    private LinearLayout ll_wait_pay;
    private LinearLayout ll_wait_send;
    private LinearLayout ll_wait_reciever;
    private LinearLayout ll_wait_evaluate;
    private LinearLayout ll_wait_sale;
    private LinearLayout ll_collect_product;
    private LinearLayout ll_collect_store;
    private LinearLayout ll_collect_zixun;
    private LinearLayout ll_collect_zuji;







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_zszx_mine, container, false);
            bindView(view);
            setCallBack();
        }
        return view;
    }

    private void setCallBack() {

        RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        Glide.with(this)
                .load(R.mipmap.zhanwei_classfy_food)
                .apply(mRequestOptions)
                .into(iv);

        gv.setAdapter(new FoodDiscountsAdapter(context));
        iv_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SetActivity.class);
            }
        });
        ll_jifen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(IntegralActivity.class);
            }
        });
        ll_youhuijuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CouponActivity.class);
            }
        });



        ll_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderStateActivity.class);
                intent.putExtra("state",0);
                startActivity(intent);
            }
        });
        ll_wait_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderStateActivity.class);
                intent.putExtra("state",0);
                startActivity(intent);
            }
        });
        ll_wait_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderStateActivity.class);
                intent.putExtra("state",1);
                startActivity(intent);
            }
        });
        ll_wait_reciever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderStateActivity.class);
                intent.putExtra("state",2);
                startActivity(intent);
            }
        });
        ll_wait_evaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderStateActivity.class);
                intent.putExtra("state",3);
                startActivity(intent);
            }
        });
        ll_wait_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderStateActivity.class);
                intent.putExtra("state",4);
                startActivity(intent);
            }
        });

        ll_collect_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"收藏商品");
            }
        });
        ll_collect_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"收藏店铺");
            }
        });
        ll_collect_zixun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"收藏咨询");
            }
        });
        ll_collect_zuji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"收藏足迹");
            }
        });



    }

    private void bindView(View view) {


        ll_base_title = (FrameLayout) view.findViewById(R.id.ll_base_title);
        iv_set = (ImageView) view.findViewById(R.id.iv_set);
        iv = (ImageView) view.findViewById(R.id.iv);
        ll_youhuijuan = (LinearLayout) view.findViewById(R.id.ll_youhuijuan);
        ll_jifen = (LinearLayout) view.findViewById(R.id.ll_jifen);
        ll_more = (LinearLayout) view.findViewById(R.id.ll_more);
        ll_wait_pay = (LinearLayout) view.findViewById(R.id.ll_wait_pay);
        ll_wait_send = (LinearLayout) view.findViewById(R.id.ll_wait_send);
        ll_wait_reciever = (LinearLayout) view.findViewById(R.id.ll_wait_reciever);
        ll_wait_evaluate = (LinearLayout) view.findViewById(R.id.ll_wait_evaluate);
        ll_wait_sale = (LinearLayout) view.findViewById(R.id.ll_wait_sale);
        ll_collect_product = (LinearLayout) view.findViewById(R.id.ll_collect_product);
        ll_collect_store = (LinearLayout) view.findViewById(R.id.ll_collect_store);
        ll_collect_zixun = (LinearLayout) view.findViewById(R.id.ll_collect_zixun);
        ll_collect_zuji = (LinearLayout) view.findViewById(R.id.ll_collect_zuji);
        gv = (com.zszx.b2c.view.MyGradView) view.findViewById(R.id.gv);
    }

    @Override
    public View initView() {
        return null;
    }

    public  void startActivity(Class aClass){
        startActivity(new Intent(getActivity(),aClass));
    }
}
