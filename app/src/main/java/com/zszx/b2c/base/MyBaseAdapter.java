package com.zszx.b2c.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class MyBaseAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return getNum();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getContenView(i, view,viewGroup);

    }
    public abstract View getContenView(int i, View view, ViewGroup viewGroup);
    public abstract int getNum();

}
