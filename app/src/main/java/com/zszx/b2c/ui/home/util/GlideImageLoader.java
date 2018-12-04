package com.zszx.b2c.ui.home.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoaderInterface;

/**
 * Created by wxm on 2018/11/12.
 * 轮播加载工具类
 */
public class GlideImageLoader implements ImageLoaderInterface {
    @Override
    public void displayImage(Context context, Object path, View imageView) {
        Glide.with(context).load(path).into((ImageView) imageView);
    }

    @Override
    public View createImageView(Context context) {
        return null;
    }

}