package com.zszx.b2c.entity.classify;

import java.util.List;

/**
 * Created by wxm on 2018/12/14.
 */
public class ClassTitleBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1544777602
     * data : {"rec":[{"name":"新鲜水果","id":16,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"新鲜水果","id":16,"image":"/assets/img/qrcode.png","pid":0,"sun":[]},{"name":"粮食制品","id":17,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"豆制加工","id":33,"image":"/assets/img/qrcode.png","pid":17}]}]},{"name":"粮食制品","id":17,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"新鲜水果","id":16,"image":"/assets/img/qrcode.png","pid":0,"sun":[]},{"name":"粮食制品","id":17,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"豆制加工","id":33,"image":"/assets/img/qrcode.png","pid":17}]}]}],"data":[{"name":"新鲜水果","id":16,"image":"/assets/img/qrcode.png","pid":0,"sun":[]},{"name":"粮食制品","id":17,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"优质大米","id":30,"image":"/assets/img/qrcode.png","pid":17,"sun":[]},{"name":"加工制品","id":31,"image":"/assets/img/qrcode.png","pid":17,"sun":[]},{"name":"特色面食","id":32,"image":"/assets/img/qrcode.png","pid":17,"sun":[]},{"name":"豆制加工","id":33,"image":"/assets/img/qrcode.png","pid":17,"sun":[]}]},{"name":"精品小吃","id":19,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"糕点甜品","id":34,"image":"/assets/img/qrcode.png","pid":19,"sun":[]},{"name":"辛辣小吃","id":35,"image":"/assets/img/qrcode.png","pid":19,"sun":[]},{"name":"果脯蜜饯","id":36,"image":"/assets/img/qrcode.png","pid":19,"sun":[]},{"name":"肉干肉脯","id":37,"image":"/assets/img/qrcode.png","pid":19,"sun":[]},{"name":"地方特色","id":38,"image":"/assets/img/qrcode.png","pid":19,"sun":[]}]},{"name":"肉类制品","id":20,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"熟食肉类","id":39,"image":"/assets/img/qrcode.png","pid":20,"sun":[]},{"name":"生鲜肉类","id":40,"image":"/assets/img/qrcode.png","pid":20,"sun":[]},{"name":"腌制精品","id":41,"image":"/assets/img/qrcode.png","pid":20,"sun":[]}]},{"name":"酱料调味","id":21,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"食用油","id":42,"image":"/assets/img/qrcode.png","pid":21,"sun":[]},{"name":"调味品","id":43,"image":"/assets/img/qrcode.png","pid":21,"sun":[]},{"name":"酱料制品","id":44,"image":"/assets/img/qrcode.png","pid":21,"sun":[]}]},{"name":"中华茗茶","id":22,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"精选绿茶","id":45,"image":"/assets/img/qrcode.png","pid":22,"sun":[]},{"name":"精品红茶","id":46,"image":"/assets/img/qrcode.png","pid":22,"sun":[]},{"name":"优质花茶","id":48,"image":"/assets/img/qrcode.png","pid":22,"sun":[]}]},{"name":"坚果炒货","id":23,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"带壳烘炒类","id":49,"image":"/assets/img/qrcode.png","pid":23,"sun":[]},{"name":"无壳烘炒类","id":50,"image":"/assets/img/qrcode.png","pid":23,"sun":[]},{"name":"裹衣烘炒类","id":51,"image":"/assets/img/qrcode.png","pid":23,"sun":[]},{"name":"油炸类","id":52,"image":"/assets/img/qrcode.png","pid":23,"sun":[]}]},{"name":"醇香酒业","id":28,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"百年老酒","id":53,"image":"/assets/img/qrcode.png","pid":28,"sun":[]},{"name":"酱香型酒","id":54,"image":"/assets/img/qrcode.png","pid":28,"sun":[]},{"name":"清香型酒","id":55,"image":"/assets/img/qrcode.png","pid":28,"sun":[]}]},{"name":"饮料冲调","id":57,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"饮料","id":56,"image":"/assets/img/qrcode.png","pid":57,"sun":[]},{"name":"蜂蜜","id":58,"image":"/assets/img/qrcode.png","pid":57,"sun":[]},{"name":"牛奶酸奶","id":59,"image":"/assets/img/qrcode.png","pid":57,"sun":[]},{"name":"冲饮谷物","id":60,"image":"/assets/img/qrcode.png","pid":57,"sun":[]}]}]}
     */

    public int code;
    public String msg;
    public String time;
    public DataBeanX data;

    public static class DataBeanX {
        public List<RecBean> rec;
        public List<DataBean> data;

        public static class RecBean {
            /**
             * name : 新鲜水果
             * id : 16
             * image : /assets/img/qrcode.png
             * pid : 0
             * sun : [{"name":"新鲜水果","id":16,"image":"/assets/img/qrcode.png","pid":0,"sun":[]},{"name":"粮食制品","id":17,"image":"/assets/img/qrcode.png","pid":0,"sun":[{"name":"豆制加工","id":33,"image":"/assets/img/qrcode.png","pid":17}]}]
             */

            public String name;
            public int id;
            public String image;
            public int pid;
            public List<SunBean> sun;

            public static class SunBean {
                /**
                 * name : 新鲜水果
                 * id : 16
                 * image : /assets/img/qrcode.png
                 * pid : 0
                 * sun : []
                 */

                public String name;
                public int id;
                public String image;
                public int pid;
                public List<?> sun;
            }
        }

        public static class DataBean {
            /**
             * name : 新鲜水果
             * id : 16
             * image : /assets/img/qrcode.png
             * pid : 0
             * sun : []
             */

            public String name;
            public int id;
            public String image;
            public int pid;
            public List<?> sun;
        }
    }
}
