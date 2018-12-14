package com.zszx.b2c.entity;

/**
 * Created by wxm on 2018/12/11.
 * //登录成功
 */
public class loginSuccessEntity {

    /**
     * code : 1
     * msg : 登录成功
     * time : 1544493266
     * data : {"userinfo":{"id":5,"username":"18201408269","nickname":"18201408269","mobile":"18201408269","avatar":"/assets/img/avatar.png","score":0,"token":"8cebfe11-ee22-4368-a897-b7d994dd7afb","user_id":5,"createtime":1544493266,"expiretime":1547085266,"expires_in":2592000}}
     */

    public int code;
    public String msg;
    public String time;
    public DataBean data;

    public static class DataBean {
        /**
         * userinfo : {"id":5,"username":"18201408269","nickname":"18201408269","mobile":"18201408269","avatar":"/assets/img/avatar.png","score":0,"token":"8cebfe11-ee22-4368-a897-b7d994dd7afb","user_id":5,"createtime":1544493266,"expiretime":1547085266,"expires_in":2592000}
         */

        public UserinfoBean userinfo;

        public static class UserinfoBean {
            /**
             * id : 5
             * username : 18201408269
             * nickname : 18201408269
             * mobile : 18201408269
             * avatar : /assets/img/avatar.png
             * score : 0
             * token : 8cebfe11-ee22-4368-a897-b7d994dd7afb
             * user_id : 5
             * createtime : 1544493266
             * expiretime : 1547085266
             * expires_in : 2592000
             */

            public int id;
            public String username;
            public String nickname;
            public String mobile;
            public String avatar;
            public int score;
            public String token;
            public int user_id;
            public int createtime;
            public int expiretime;
            public int expires_in;
        }
    }
}
