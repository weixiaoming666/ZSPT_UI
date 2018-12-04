package com.zszx.b2c.net;

import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by wxm
 * 优化下业务逻辑
 * 这里只需要一个参数 余下的操作交给实现类
 */

public interface NetHttpIP<T> {
    void request(RequestParams params, String url, HttpRequest.HttpMethod requestType);
}
