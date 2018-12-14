package com.zszx.b2c.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wxm on 2018/12/11.
 *sp 存储
 *
 */
public class SpUtill {



//    个人信息

    public static final String USER_ID = "user_id";//用户id
    public static final String USER_NAME = "username";
    public static final String MOBILE = "mobile";
    public static final String SCORE = "score";
    public static final String TOKEN = "token";


    private static SharedPreferences sp;
    private static SpUtill instance = new SpUtill();
    private SpUtill() {
    };

    public static SpUtill getInstance(Context context) {
        if(sp==null) {
            sp = context.getApplicationContext().getSharedPreferences("ejianli", Context.MODE_PRIVATE);
        }
        return instance;
    }

    /**
     * 1. 保存数据
     */
    public void save(String key, Object value) {
        if(value instanceof Integer) {
            sp.edit().putInt(key, (Integer)value).commit();
        } else if(value instanceof String) {
            sp.edit().putString(key, (String)value).commit();
        } else if(value instanceof Boolean) {
            sp.edit().putBoolean(key, (Boolean)value).commit();
        }
    }

    /**
     * 2. 读取数据
     */
    public int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }
    public String getString(String key, String defValue) {
        return sp.getString(key, defValue);
    }
    public boolean getBoolean(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    /**
     * 读取数据
     * @param key
     * @param defValue
     * @return
     */
    public <T> T get(String key, T defValue) {
        T t = null;
        if(defValue instanceof String || defValue==null) {
            String value = sp.getString(key, (String) defValue);
            t = (T) value;
        } else if(defValue instanceof Integer) {
            Integer value = sp.getInt(key, (Integer) defValue);
            t = (T) value;
        }else if(defValue instanceof Boolean) {
            Boolean value = sp.getBoolean(key, (Boolean) defValue);
            t = (T) value;
        }
        return t;
    }

    /**
     * 3. 移除数据
     */
    public void remove(String key) {
        sp.edit().remove(key).commit();
    }
    /**
     * 清除所有数据
     * @param
     */
    public void clear()
    {
        sp.edit().clear().commit();
    }

}
