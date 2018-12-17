package com.zszx.b2c.net;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxm on 2018/10/19.
 * 合同网络请求
 *
 */
public enum   ContractNet{
    INSTANCE;
    /**
     *  获取验证码
     * */
  public void send(RequestParams params, MyCallBack callBack, Context context){
        net(params, ConstantUtils.send, HttpRequest.HttpMethod.GET,callBack,context);
    }
    /**
     *  检测验证码 /api/sms/check
     * */
    public void check(RequestParams params, MyCallBack callBack, Context context){
        net(params, ConstantUtils.check, HttpRequest.HttpMethod.GET,callBack,context);
    }
    /**
     *  获取首页信息 /api/index/index
     * */
    public void home_index(RequestParams params, MyCallBack callBack, Context context){
        net(params, ConstantUtils.home_index, HttpRequest.HttpMethod.POST,callBack,context);
    }

    /**
     *  获取首页信息 /api/index/index
     * */
    public void home_projectCategory(RequestParams params, MyCallBack callBack, Context context){
        net(params, ConstantUtils.home_projectCategory, HttpRequest.HttpMethod.POST,callBack,context);
    }
    /**
     *  热搜历史 /api/index/index
     * */
    public void hotSearch(RequestParams params, MyCallBack callBack, Context context){
        net(params, ConstantUtils.hotSearch, HttpRequest.HttpMethod.GET,callBack,context);
    }
    /**
     *  热搜历史 /api/index/index
     * */
    public void oldshop(RequestParams params, MyCallBack callBack, Context context){
        net(params, ConstantUtils.oldshop, HttpRequest.HttpMethod.POST,callBack,context);
    }
    /**
     *  首页搜索
     * */
    public void search(RequestParams params, MyCallBack callBack, Context context){
        net(params, ConstantUtils.search, HttpRequest.HttpMethod.POST,callBack,context);
    }
    /**
     *   上传文件
     * */
    public void postFile(List<File> files, String url, Map map, final Context context, PostFileSuccess fileSuccess){
        netFile(files,url,map,context,fileSuccess);
    }

    private void netFile(List<File> files, String url, Map map, final Context context, PostFileSuccess fileSuccess) {
        RequestQueue mQueue = Volley.newRequestQueue(context);
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("正在上传...");
        MultipartRequest request = new MultipartRequest(url, fileSuccess, fileSuccess, "files", files, map) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", (String) SpUtils.getInstance(context).get(SpUtils.TOKEN, null));
                return headers;
            }
        };
        mQueue.add(request);
    }



    /**
     * @param params  参数
     */
    public void net(RequestParams params, String url, HttpRequest.HttpMethod type, MyCallBack callBack, Context context){//钱包id
        AddRecodNet netHttpIP = new AddRecodNet(callBack);
        netHttpIP.request(params, url, type);
    }
}
