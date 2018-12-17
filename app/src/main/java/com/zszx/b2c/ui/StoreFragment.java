package com.zszx.b2c.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.widget.IRenderView;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.zszx.b2c.R;
import com.zszx.b2c.base.BaseFragment;
import com.zszx.b2c.entity.home.HotSearchEntity;
import com.zszx.b2c.entity.store.StoreMainEntity;
import com.zszx.b2c.net.ConstantUtils;
import com.zszx.b2c.net.ContractNet;
import com.zszx.b2c.net.MyCallBack;
import com.zszx.b2c.ui.classify.CheckPositionCallBack;
import com.zszx.b2c.ui.classify.adapter.TitleMainAdapter;
import com.zszx.b2c.ui.classify.fragment.ClassfyTab1Fragment;
import com.zszx.b2c.ui.home.adapter.FragmentAdapter;
import com.zszx.b2c.ui.my.OldStoreMainActivity;
import com.zszx.b2c.ui.my.adapter.StoreAdapter;
import com.zszx.b2c.ui.my.adapter.TitleOldMainAdapter;
import com.zszx.b2c.utils.SpUtill;
import com.zszx.b2c.utils.ToastUtil;
import com.zszx.b2c.view.MyGradView;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

//老字号
public class StoreFragment extends BaseFragment {
    View view;
    private SearchView   sv;
    private LinearLayout ll_search;
    private MyListview   mlv;
//    private RadioGroup                     rg;
//    private RadioButton                    rb_0;
//    private RadioButton                    rb_1;
//    private RadioButton                    rb_2;
//    private RadioButton                    rb_3;
//    private RadioButton                    rb_4;
//    private RadioButton                    rb_5;
//    private RadioButton                    rb_6;
//    private RadioButton                    rb_7;
//    private RadioButton                    rb_8;
//    private RadioButton                    rb_9;
    private LinearLayout ll_store_1;
    private JzvdStd video;
    private TextView     tv_content;
    private ImageView    iv_back_top;
    private MyGradView   mgv_store;
    private List<StoreMainEntity.DataBean> data = new ArrayList<>();
    private TitleOldMainAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_zszx_store, container, false);
            context = getActivity();
            bindView(view);
            setCallBack();
            net();
        }

        return view;
    }

    private void net() {
        RequestParams params = new RequestParams();
        ContractNet.INSTANCE.oldshop(params, new MyCallBack<StoreMainEntity>() {
            @Override
            public void onMySucess(StoreMainEntity entity) {
                if (entity == null){
                    ToastUtil.showShort(getActivity(),"请求数据为空");
                }else {
                    data = entity.data;
                    showData(data.get(0));
                }

            }
            @Override
            public void onMyFail(HttpException e, String s) {
                ToastUtil.showShort(getActivity(),s);
            }
        },getActivity());
    }
    String url = "https://www.sample-videos.com/index.php#sample-mp4-video";
    private void showData(StoreMainEntity.DataBean entity) {
        if (mAdapter!=null){
            video.changeUrl(url,"老店详情",1000);
        }else {
            video.setUp(url
                    , "老店详情", Jzvd.SCREEN_WINDOW_NORMAL);
        }
        Glide.with(context).load(ConstantUtils.base_url_host+entity.black_image).into(video.thumbImageView);
        if (mAdapter == null){
            mAdapter=new TitleOldMainAdapter(getActivity(),data, new CheckPositionCallBack() {
                @Override
                public void checked(int position) {
                    if (position ==1 ){
                        url = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";
                    }else {
                         url = "https://www.sample-videos.com/index.php#sample-mp4-video";
                    }
                    showData(data.get(position));

                }
            });
            mlv.setAdapter(mAdapter);
        }
        tv_content.setText(entity.content);
        Glide.with(context).load(ConstantUtils.base_url_host+entity.black_image).into(iv_back_top);
        mgv_store.setAdapter(new StoreAdapter(entity.shop,context));
    }

    private void setCallBack() {

    }

    private void bindView(View view) {
//        sv = view.findViewById(R.id.sv);
//        rg = (RadioGroup) view.findViewById(R.id.rg);
//        rb_0 = (RadioButton) view.findViewById(R.id.rb_0);
//        rb_1 = (RadioButton) view.findViewById(R.id.rb_1);
//        rb_2 = (RadioButton) view.findViewById(R.id.rb_2);
//        rb_3 = (RadioButton) view.findViewById(R.id.rb_3);
//        rb_4 = (RadioButton) view.findViewById(R.id.rb_4);
//        rb_5 = (RadioButton) view.findViewById(R.id.rb_5);
//        rb_6 = (RadioButton) view.findViewById(R.id.rb_6);
//        rb_7 = (RadioButton) view.findViewById(R.id.rb_7);
//        rb_8 = (RadioButton) view.findViewById(R.id.rb_8);
//        rb_9 = (RadioButton) view.findViewById(R.id.rb_9);
        mlv =  view.findViewById(R.id.mlv);
        video =  view.findViewById(R.id.video);
        tv_content =  view.findViewById(R.id.tv_content);
        iv_back_top =  view.findViewById(R.id.iv_back_top);
        mgv_store =  view.findViewById(R.id.mgv_store);
//        //获取到TextView的ID
//        int id = sv.getContext().getResources().getIdentifier("android:id/search_src_text",null,null);
//        //获取到TextView的控件
//        SearchView.SearchAutoComplete textView =  sv.findViewById(R.id.search_src_text);
//        //设置字体大小为14sp
//        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);//14sp
//        sv.setIconifiedByDefault(false);
//        sv.setSubmitButtonEnabled(true);

    }

    @Override
    public View initView() {
        return null;
    }
    @Override
    public void initData() {

    }


    @Override
    public void onResume() {
        super.onResume();
        //home back
        JzvdStd.goOnPlayOnResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        JzvdStd.goOnPlayOnPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        JzvdStd.releaseAllVideos();
    }
}
