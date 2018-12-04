package com.zszx.b2c.utils;

import android.content.Context;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class LoginByThird {
    private static  final  String APP_ID_WX = "wx89d18947eeef1f42";
    private IWXAPI api;

    public  void LoginByWX(Context context){
        api = WXAPIFactory.createWXAPI(context,APP_ID_WX,true);
        api.registerApp("APP_ID_WX");
    }
}
