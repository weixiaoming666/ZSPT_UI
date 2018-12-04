package com.zszx.b2c.ui.location;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import com.zszx.b2c.R;
import com.zszx.b2c.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableHeaderAdapter;
import me.yokeyword.indexablerv.IndexableLayout;

public class LocationActivity extends AppCompatActivity {
    //IndexableLayout 的适配器
    private ContactAdapter mAdapter;
    //自定义头部adapter
    private BannerHeaderAdapter mBannerHeaderAdapter;
    //热门城市的数组
    private String[] city = {"东莞","深圳","广州","温州","郑州","金华","佛山","上海","苏州","杭州","长沙","中山"};
    private IndexableLayout              indexableLayout;
    //热门城市的适配器
    private CYBChangeCityGridViewAdapter cybChangeCityGridViewAdapter;
//    热门城市的集合
    private ArrayList<String> list;
    //返回按钮
    private ImageView         pic_contact_back;
    private Intent            intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        initview();
        initAdapter();
        onlisten();
    }

    public void initAdapter(){
        mAdapter = new ContactAdapter(this);
        indexableLayout.setAdapter(mAdapter);
        //设置字母提示框为仿os居中
        indexableLayout.setOverlayStyle_Center();
        mAdapter.setDatas(initDatas());
//        indexableLayout.setOverlayStyle_MaterialDesign(Color.RED); 设置提示框为仿联系人气泡样式
        // 全字母排序。  排序规则设置为：每个字母都会进行比较排序；速度较慢
        indexableLayout.setCompareMode(IndexableLayout.MODE_FAST);
//        indexableLayout.addHeaderAdapter(new SimpleHeaderAdapter<>(mAdapter, "☆",null, null));

//         构造函数里3个参数,分别对应 (IndexBar的字母索引, IndexTitle, 数据源), 不想显示哪个就传null, 数据源传null时,代表add一个普通的View
//        mMenuHeaderAdapter = new MenuHeaderAdapter("↑", null, initMenuDatas());
//        indexableLayout.addHeaderAdapter(mMenuHeaderAdapter);

        // 这里BannerView只有一个Item, 添加一个长度为1的任意List作为第三个参数
        List<String> bannerList = new ArrayList<>();
        bannerList.add("");
        mBannerHeaderAdapter = new BannerHeaderAdapter("↑", null, bannerList);
        indexableLayout.addHeaderAdapter(mBannerHeaderAdapter);
    }

    public void initview(){
        intent = getIntent();
        pic_contact_back = (ImageView) findViewById(R.id.pic_contact_back);
        indexableLayout = (IndexableLayout) findViewById(R.id.indexableLayout);
        indexableLayout.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onlisten(){

        pic_contact_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mAdapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<UserEntity>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, UserEntity entity) {
                if (originalPosition >= 0) {
                    intent.putExtra("info", entity.getNick());
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    ToastUtil.showShort(LocationActivity.this, "选中Header/Footer:" + entity.getNick() + "  当前位置:" + currentPosition);
                }
            }
        });
    }

    /**
     * 自定义的Banner Header
     */
    class BannerHeaderAdapter extends IndexableHeaderAdapter {
        private static final int TYPE = 1;
        //这里传的参数上面注释有
        public BannerHeaderAdapter(String index, String indexTitle, List datas) {
            super(index, indexTitle, datas);
        }

        @Override
        public int getItemViewType() {
            return TYPE;
        }

        @Override
        public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(LocationActivity.this).inflate(R.layout.item_city_header, parent, false);
            VH holder = new VH(view);
            return holder;
        }

        @Override
        public void onBindContentViewHolder(RecyclerView.ViewHolder holder, Object entity) {
            // 数据源为null时, 该方法不用实现
            final VH vh = (VH) holder;
            list=new ArrayList<>();
            for(int i = 0; i<city.length; i++){
                list.add(city[i]);
            }
            System.out.println("------------city"+list);
            cybChangeCityGridViewAdapter=new CYBChangeCityGridViewAdapter(LocationActivity.this, list);
            // 绑定adpter
            vh.head_home_change_city_gridview.setAdapter(cybChangeCityGridViewAdapter);
            //热门城市的item点击事件
            vh.head_home_change_city_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    intent.putExtra("info", list.get(position));
                    System.out.println("aaaaaayyyyyyyyy"+list.get(position));
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
            //设置定位城市的点击事件
            vh.item_header_city_dw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("info", vh.item_header_city_dw.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });

        }

        private class VH extends RecyclerView.ViewHolder {
            GridView head_home_change_city_gridview;
            TextView item_header_city_dw;
            public VH(View itemView) {
                super(itemView);
                head_home_change_city_gridview = itemView.findViewById(R.id.item_header_city_gridview);
                item_header_city_dw = (TextView) itemView.findViewById(R.id.item_header_city_dw);
            }
        }
    }

    private List<UserEntity> initDatas() {
        List<UserEntity> list = new ArrayList<>();
        // 初始化数据，R.array.provinces是城市资源，下面有贴出资源文件代码
        List<String> contactStrings = Arrays.asList(getResources().getStringArray(R.array.provinces));
        List<String> mobileStrings = Arrays.asList(getResources().getStringArray(R.array.provinces));
        for (int i = 0; i < contactStrings.size(); i++) {
            UserEntity contactEntity = new UserEntity(contactStrings.get(i), mobileStrings.get(i));
            list.add(contactEntity);
        }
        return list;
    }


}
