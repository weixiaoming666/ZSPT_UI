package com.zszx.b2c.ui.location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zszx.b2c.R;

import me.yokeyword.indexablerv.IndexableAdapter;

class ContactAdapter extends IndexableAdapter<UserEntity> {
        private LayoutInflater mInflater;

    public ContactAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

//设置悬浮块的layout
        @Override
        public RecyclerView.ViewHolder onCreateTitleViewHolder (ViewGroup parent){
        View view = mInflater.inflate(R.layout.item_index_contact, parent, false);
        return new IndexVH(view);
    }
//设置悬浮块下面的layout
        @Override
        public RecyclerView.ViewHolder onCreateContentViewHolder (ViewGroup parent){
        View view = mInflater.inflate(R.layout.item_contact, parent, false);
        return new ContentVH(view);
    }

//设置悬浮块的数据
        @Override
        public void onBindTitleViewHolder (RecyclerView.ViewHolder holder, String indexTitle){
        IndexVH vh = (IndexVH) holder;
        vh.tv.setText(indexTitle);
    }

//设置悬浮块下面的数据
        @Override
        public void onBindContentViewHolder (RecyclerView.ViewHolder holder, UserEntity entity){
        ContentVH vh = (ContentVH) holder;
        vh.tvName.setText(entity.getNick());
        vh.tvMobile.setText(entity.getMobile());
    }

        private class IndexVH extends RecyclerView.ViewHolder {
            TextView tv;

            public IndexVH(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv_index);
            }
        }

        private class ContentVH extends RecyclerView.ViewHolder {
            TextView tvName, tvMobile;

            public ContentVH(View itemView) {
                super(itemView);
                tvName = (TextView) itemView.findViewById(R.id.tv_name);
                tvMobile = (TextView) itemView.findViewById(R.id.tv_mobile);
            }
        }
    }
