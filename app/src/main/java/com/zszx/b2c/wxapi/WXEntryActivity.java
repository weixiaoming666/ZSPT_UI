package com.zszx.b2c.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.zszx.b2c.net.MyCallBack;
import com.zszx.b2c.net.NetHttpIP;
import com.zszx.b2c.utils.UtilLog;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private static final String APP_SECRET = "26e3930eaf5212d14968b4adfa5cb75a";
    private IWXAPI mWeixinAPI;
    public static final String WEIXIN_APP_ID = "wx89d18947eeef1f42";
    private static String uuid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeixinAPI = WXAPIFactory.createWXAPI(this, WEIXIN_APP_ID, true);
        mWeixinAPI.handleIntent(this.getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        mWeixinAPI.handleIntent(intent, this);//必须调用此句话
    }

    //微信发送的请求将回调到onReq方法
    @Override
    public void onReq(BaseReq req) {

    }

    //发送到微信请求的响应结果
    @Override
    public void onResp(BaseResp resp) {
        UtilLog.d("微信登录","onResp"+resp.errCode);
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                UtilLog.d("微信登录","ERR_OK");
                //发送成功
                SendAuth.Resp sendResp = (SendAuth.Resp) resp;
                if (sendResp != null) {
                    String code = sendResp.code;
                    getAccess_token(code);
                }
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                UtilLog.d("微信登录","ERR_USER_CANCEL");
                //发送取消
                finish();
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                UtilLog.d("微信登录","ERR_AUTH_DENIED");
                //发送被拒绝
                finish();
                break;
            default:
                //发送返回
                break;
        }

    }

    /**
     * 获取openid accessToken值用于后期操作
     * @param code 请求码
     */
    private void getAccess_token(final String code) {
        String path = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                + WEIXIN_APP_ID
                + "&secret="
                + APP_SECRET
                + "&code="
                + code
                + "&grant_type=authorization_code";
        UtilLog.d("微信登录","getAccess_token：" + path);



        NetHttpIP netHttpIP = new NetHttpIP() {
            @Override
            public void request(RequestParams params, String url, HttpRequest.HttpMethod requestType) {
                HttpUtils httpUtils = new HttpUtils(5000);
                int size= (int) (Runtime.getRuntime().totalMemory()/8);
                httpUtils.configHttpCacheSize(size);

//        设置字符集的格式 UTF-8
                httpUtils.configResponseTextCharset("UTF-8");

//        设置重新联网的次数,如果连接服务器失败,重新联网的次数
                httpUtils.configRequestRetryCount(3);

//        设置多线程并发执行
                httpUtils.configRequestThreadPoolSize(4);

//        设置缓存数据失效的时间
//        设置30分钟后缓存数据失效

                httpUtils.send(requestType, url, params, new MyCallBack<String>() {
                    @Override
                    public void onMySucess(String s) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(s);
                            String openid = jsonObject.getString("openid").toString().trim();
                            String access_token = jsonObject.getString("access_token").toString().trim();
                            getUserMesg(access_token, openid);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onMyFail(HttpException e, String s) {
                        UtilLog.d("微信登录","getAccess_token：" + s);
                        UtilLog.d("微信登录","getAccess_token：" + s);

                    }
                });
            }
        };
        RequestParams params = new RequestParams();
        netHttpIP.request(params,path,HttpRequest.HttpMethod.GET);



//        //网络请求，根据自己的请求方式
//        VolleyRequest.get(this, path, "getAccess_token", false, null, new VolleyRequest.Callback() {
//            @Override
//            public void onSuccess(String result) {
//                LogUtils.log("getAccess_token_result:" + result);
//                JSONObject jsonObject = null;
//                try {
//                    jsonObject = new JSONObject(result);
//                    String openid = jsonObject.getString("openid").toString().trim();
//                    String access_token = jsonObject.getString("access_token").toString().trim();
//                    getUserMesg(access_token, openid);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onError(String errorMessage) {
//
//            }
//        });
    }


    /**
     * 获取微信的个人信息
     * @param access_token
     * @param openid
     */
    private void getUserMesg(final String access_token, final String openid) {
        String path = "https://api.weixin.qq.com/sns/userinfo?access_token="
                + access_token
                + "&openid="
                + openid;
        NetHttpIP netHttpIP = new NetHttpIP() {
            @Override
            public void request(RequestParams params, String url, HttpRequest.HttpMethod requestType) {
                HttpUtils httpUtils = new HttpUtils(0);
                httpUtils.send(requestType, url, params, new MyCallBack<String>() {
                    @Override
                    public void onMySucess(String s) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(s);
                            String nickname = jsonObject.getString("nickname");
                            int sex = Integer.parseInt(jsonObject.get("sex").toString());
                            String headimgurl = jsonObject.getString("headimgurl");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        finish();
                    }

                    @Override
                    public void onMyFail(HttpException e, String s) {

                    }
                });
            }
        };
        RequestParams params = new RequestParams();
        netHttpIP.request(params,path,HttpRequest.HttpMethod.GET);

//        //网络请求，根据自己的请求方式
//        VolleyRequest.get(this, path, "getAccess_token", false, null, new VolleyRequest.Callback() {
//            @Override
//            public void onSuccess(String result) {
//
//                JSONObject jsonObject = null;
//                try {
//                    jsonObject = new JSONObject(result);
//                    String nickname = jsonObject.getString("nickname");
//                    int sex = Integer.parseInt(jsonObject.get("sex").toString());
//                    String headimgurl = jsonObject.getString("headimgurl");
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                finish();
//            }
//
//            @Override
//            public void onError(String errorMessage) {
//
//            }
//        });
    }


}
