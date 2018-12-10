package com.zszx.b2c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.zszx.b2c.entity.duanxin.SendEntity;
import com.zszx.b2c.net.ContractNet;
import com.zszx.b2c.net.MyCallBack;
import com.zszx.b2c.utils.ToastUtil;
import com.zszx.b2c.wxapi.WXEntryActivity;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class LoginActivity extends AppCompatActivity {

    private EditText  et_phone;
    private EditText  et_numnber;
    private Button    bt_get_num;
    private Button    bt_login;
    private ImageView iv_log_weixin;
    private ImageView iv_log_qq;
    private ImageView iv_log_weibo;
    private Context mContext;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        if (Build.VERSION.SDK_INT >= 21) {
             getWindow().setStatusBarColor(getColor(R.color.calendar_selected_day_bg2));
        }
        bindViews();
        bindListener();
    }

    private void bindListener() {
        bt_get_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();//发送短信
                Toast.makeText(LoginActivity.this,"获取验证码为：123456",Toast.LENGTH_SHORT).show();
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                if (TextUtils.isEmpty(et_phone.getText())){
                    Toast.makeText(LoginActivity.this,"请输入电话号码",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(et_numnber.getText())){
                    Toast.makeText(LoginActivity.this,"请输入验证码",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    if (et_numnber.getText().toString().equals("123456")){
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(LoginActivity.this,"验证码错误",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        iv_log_weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"微信登录ing",Toast.LENGTH_SHORT).show();

//                loginToWeiXin();

            }
        });

        iv_log_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"qq登陆ing",Toast.LENGTH_SHORT).show();
            }
        });

        iv_log_weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"微博登陆ing",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void send() {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("mobile",et_phone.getText().toString());
        ContractNet.INSTANCE.send(params, new MyCallBack<SendEntity>() {
            @Override
            public void onMySucess(SendEntity sendEntity) {
                ToastUtil.showShort(mContext,"验证码已发送，请填写验证码");
            }
            @Override
            public void onMyFail(HttpException e, String s) {
                ToastUtil.showShort(mContext,s);
            }
        },this);
    }

    private void check() {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("mobile",et_phone.getText().toString());
        if (et_numnber.getText() != null && !et_numnber.getText().toString().isEmpty()){
            params.addQueryStringParameter("captcha",et_numnber.getText().toString());
        }else {
            ToastUtil.showShort(mContext,"请输入验证码");
        }
        ContractNet.INSTANCE.check(params, new MyCallBack<SendEntity>() {
            @Override
            public void onMySucess(SendEntity sendEntity) {
//                验证码成功
            }
            @Override
            public void onMyFail(HttpException e, String s) {
                ToastUtil.showShort(mContext,s);
            }
        },this);
    }


    private void bindViews() {

        et_phone = (EditText) findViewById(R.id.et_phone);
        et_numnber = (EditText) findViewById(R.id.et_numnber);
        bt_get_num = (Button) findViewById(R.id.bt_get_num);
        bt_login = (Button) findViewById(R.id.bt_login);
        iv_log_weixin = (ImageView) findViewById(R.id.iv_log_weixin);
        iv_log_qq = (ImageView) findViewById(R.id.iv_log_qq);
        iv_log_weibo = (ImageView) findViewById(R.id.iv_log_weibo);
    }
    public boolean onTouchEvent(MotionEvent event) {
        if (null != this.getCurrentFocus()) {
            /**
             * 点击空白位置 隐藏软键盘
             */
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }

    // 点击空白区域 自动隐藏软键盘
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v != null ? v.getWindowToken() : null, 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了  
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    public  boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = { 0, 0 };
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private void loginToWeiXin(){
        IWXAPI mApi = WXAPIFactory.createWXAPI(this, WXEntryActivity.WEIXIN_APP_ID, true);
        mApi.registerApp(WXEntryActivity.WEIXIN_APP_ID);
        if (mApi != null && mApi.isWXAppInstalled()) {
            SendAuth.Req req = new SendAuth.Req();
//            req.scope = "jQG03bbmFg1yvcOh5guPvwpPxQ7BvDiv";
            req.scope = "snsapi_userinfo";
            req.state = "wechat_sdk_demo_test_neng";

            mApi.sendReq(req);
        } else
            Toast.makeText(this, "用户未安装微信", Toast.LENGTH_SHORT).show();
    }
}
