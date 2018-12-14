package com.zszx.b2c.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.lljjcoder.citylist.Toast.ToastUtils;
import com.zszx.b2c.R;
import com.zszx.b2c.utils.AlbumUtils;
import com.zszx.b2c.utils.DialogButtonOnClickListener;
import com.zszx.b2c.utils.ToastUtil;

import java.io.File;

public class RefundActivityTwoActivity extends AppCompatActivity {

    private EditText    et;
    private ImageView   iv_add;
    private ImageView   iv_back;
    private RadioGroup  rg;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private TextView    tv_refund;
    private Context     context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund_two);
        context = this;
        bindView();
        bindListener();


    }

    private void bindListener() {
        tv_refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context,"申请成功");
                finish();
            }
        });
        iv_add.setOnClickListener(new View.OnClickListener() {//
            @Override
            public void onClick(View v) {
                ToastUtil.showDialog(context, "选择图片方式", "相册", "拍照", new DialogButtonOnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent intent = new Intent(Intent.ACTION_PICK, null);
                        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                        startActivityForResult(intent, 1);
                    }
                }, new DialogButtonOnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        String sdStatus = Environment.getExternalStorageState();
                        /* 检测sd是否可用 */
                        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                            ToastUtils.showShortToast(context, "SD卡不可用！");
                            return;
                        }
                        Intent camera = new Intent("android.media.action.IMAGE_CAPTURE");
                        startActivityForResult(camera, 2);
                    }
                });
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void bindView() {
        et = (EditText) findViewById(R.id.et);
        iv_add = (ImageView) findViewById(R.id.iv_add);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        tv_refund = (TextView) findViewById(R.id.tv_refund);
        iv_back =  findViewById(R.id.iv_back);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    String path = AlbumUtils.getAlbumPath(data,context);//照片路径
                    File xiangceFile = new File(path);
                    if (!xiangceFile.exists()) {
                        ToastUtils.showShortToast(context, "当前文件不存在或者无效");
                        return;
                    }

                    BitmapFactory.Options options1 = new BitmapFactory.Options();
                    options1.inSampleSize = 2;
                    Log.i("path", path);
                    break;
                case 2:
                    ToastUtils.showShortToast(context, "拍摄成功");
                    String picturePath = AlbumUtils.getPhoto(data, context);//拍照路径
                    File zhaoxiangfile = new File(picturePath);
                    BitmapUtils bitmapUtils = new BitmapUtils(context);
//                    bitmapUtils.display(iv_new_piv, picturePath);

                    break;

            }
        }
    }
}
