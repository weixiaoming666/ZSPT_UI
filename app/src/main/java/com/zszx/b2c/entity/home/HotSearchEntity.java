package com.zszx.b2c.entity.home;

import java.util.List;

public class HotSearchEntity {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1545048678
     * data : {"host":["1","东方芒果台芭","3","155","西","w","光肌密","","1111","5555"],"history":["测试","测试","wife","wife","wife","","","","3","155"]}
     */

    public int code;
    public String   msg;
    public String   time;
    public DataBean data;

    public static class DataBean {
        public List<String> host;
        public List<String> history;
    }
}
