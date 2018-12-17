package com.zszx.b2c.entity.home;

import java.util.List;

public class SearchEntity {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1545060354
     * data : {"project":[],"shop":[{"id":1,"name":"西直门店","black_image":"/uploads/20181213/ca56e2051e87ad832d9f1c283304f08a.jpg","log_image":"/uploads/20181213/063443df37fe4dc79ee844213d887002.jpg","prject":[{"name":"老孙家羊肉泡馍170g*5 陕西特产西安小吃清真方便食品中华老字号","id":4,"image":"/uploads/20181207/f7d02d0aa6f46c53b887895cb81fbc15.jpg","price_market":600,"price_discount":500,"quality_text":"","state_text":""},{"name":"月盛斋 清真牛肉真空包装即食熟食 中华老字号 五香酱牛肉200g","id":5,"image":"/uploads/20181207/f49a1caac1848856a5d4faeac2ff4f72.jpg","price_market":600,"price_discount":400.04,"quality_text":"","state_text":""},{"name":"沟帮子 尹家 中华老字号 鲜熏鸡公900g/只 非扒鸡烧鸡 熟食卤味 休闲零食","id":6,"image":"/uploads/20181207/29ef3e4488030bdf25e2a88189b2d976.jpg","price_market":0,"price_discount":0,"quality_text":"","state_text":""}],"collection_count":0,"state_text":""},{"id":2,"name":"德胜门店","black_image":"/uploads/20181213/ca56e2051e87ad832d9f1c283304f08a.jpg","log_image":"/uploads/20181213/063443df37fe4dc79ee844213d887002.jpg","prject":[{"name":"中华老字号 梅林 MALING 午餐肉罐头 火锅必备 340g*2","id":1,"image":"/uploads/20181127/3ed3dc870881bb25d4ff4efee9ff7328.jpg","price_market":0.01,"price_discount":0.01,"quality_text":"","state_text":""},{"name":"松鹤楼 核桃酥 中华老字号 糕点饼干 休闲零食 中秋礼盒 苏州特产食品 儿童老人小吃 蛋糕点心700g","id":2,"image":"/uploads/20181207/f49a1caac1848856a5d4faeac2ff4f72.jpg","price_market":0.01,"price_discount":0.01,"quality_text":"","state_text":""},{"name":"德州扒鸡 山东特产 正宗中华老字号清真熟食烧鸡 五香精选童子鸡 500g","id":3,"image":"/uploads/20181207/4c27c63204ca4343790e4653d2edf283.jpg","price_market":500,"price_discount":300,"quality_text":"","state_text":""}],"collection_count":0,"state_text":""},{"id":3,"name":"eee","black_image":"/uploads/20181213/ca56e2051e87ad832d9f1c283304f08a.jpg","log_image":"/uploads/20181207/4c27c63204ca4343790e4653d2edf283.jpg","prject":[{"name":"北京稻香村 老北京糕点礼盒1550g 休闲糕点点心早餐下午茶北京特产中华老字号 （新老包装随机发放）","id":21,"image":"/uploads/20181207/b3adbaf0ac1bc88af56e3c59667dadd7.jpg","price_market":0,"price_discount":55,"quality_text":"","state_text":""},{"name":"北京稻香村 鸡蛋槽子糕312g 鸡蛋蜂蜜蛋糕休闲糕点小吃点心早餐下午茶北京特产中华老字号","id":22,"image":"/uploads/20181207/1104ccfb88c3395a6716dd838789a14c.jpg","price_market":800,"price_discount":55,"quality_text":"","state_text":""},{"name":"知味观 中华老字号 艾草青团 3盒装蛋黄肉松豆沙麻芯青团 杭州特产茶点","id":23,"image":"/uploads/20181207/e0189b794d16e87684365f09b038accd.jpg","price_market":0,"price_discount":0,"quality_text":"","state_text":""}],"collection_count":0,"state_text":""}],"news":[]}
     */

    public int code;
    public String   msg;
    public String   time;
    public DataBean data;

    public static class DataBean {
        public List<?>        project;
        public List<ShopBean> shop;
        public List<?>        news;

        public static class ShopBean {
            /**
             * id : 1
             * name : 西直门店
             * black_image : /uploads/20181213/ca56e2051e87ad832d9f1c283304f08a.jpg
             * log_image : /uploads/20181213/063443df37fe4dc79ee844213d887002.jpg
             * prject : [{"name":"老孙家羊肉泡馍170g*5 陕西特产西安小吃清真方便食品中华老字号","id":4,"image":"/uploads/20181207/f7d02d0aa6f46c53b887895cb81fbc15.jpg","price_market":600,"price_discount":500,"quality_text":"","state_text":""},{"name":"月盛斋 清真牛肉真空包装即食熟食 中华老字号 五香酱牛肉200g","id":5,"image":"/uploads/20181207/f49a1caac1848856a5d4faeac2ff4f72.jpg","price_market":600,"price_discount":400.04,"quality_text":"","state_text":""},{"name":"沟帮子 尹家 中华老字号 鲜熏鸡公900g/只 非扒鸡烧鸡 熟食卤味 休闲零食","id":6,"image":"/uploads/20181207/29ef3e4488030bdf25e2a88189b2d976.jpg","price_market":0,"price_discount":0,"quality_text":"","state_text":""}]
             * collection_count : 0
             * state_text :
             */

            public int id;
            public String           name;
            public String           black_image;
            public String           log_image;
            public int              collection_count;
            public String           state_text;
            public List<PrjectBean> prject;

            public static class PrjectBean {
                /**
                 * name : 老孙家羊肉泡馍170g*5 陕西特产西安小吃清真方便食品中华老字号
                 * id : 4
                 * image : /uploads/20181207/f7d02d0aa6f46c53b887895cb81fbc15.jpg
                 * price_market : 600
                 * price_discount : 500
                 * quality_text :
                 * state_text :
                 */

                public String name;
                public int    id;
                public String image;
                public int    price_market;
                public int    price_discount;
                public String quality_text;
                public String state_text;
            }
        }
    }
}
