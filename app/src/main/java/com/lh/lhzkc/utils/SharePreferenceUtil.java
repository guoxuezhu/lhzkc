package com.lh.lhzkc.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 共享参数类
 */
@SuppressLint("CommitPrefEdits")
public class SharePreferenceUtil {
    private SharedPreferences sp;
    private Editor editor;


    /**
     * 构造函数
     */
    public SharePreferenceUtil(Context context, String file) {
        sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        // 利用edit()方法获取Editor对象。
        editor = sp.edit();
    }

    public void setZKIP(String zkip) {
        editor.putString("zkip", zkip);
        editor.commit();
    }

    public String getZKIP() {
        return sp.getString("zkip", "");
    }


    public String getUdid() {
        return sp.getString("uuid", null);
    }

    public void setUdid(String uuid) {
        editor.putString("uuid", uuid);
        editor.commit();
    }

    public void setzkname(String zkname) {
        editor.putString("zkname", zkname);
        editor.commit();
    }

    public String getzkname() {
        return sp.getString("zkname", "");
    }


    public void setMqttuser(String mqttuser) {
        editor.putString("mqttuser", mqttuser);
        editor.commit();
    }

    public String getMqttuser() {
        return sp.getString("mqttuser", "");
    }


    public void setAppToken(String appToken) {
        editor.putString("appToken", appToken);
        editor.commit();
    }

    public String getAppToken() {  // vZakahehxugRHnZs
        return sp.getString("appToken", "");
    }

    public void setIsip(boolean isIp) {
        editor.putBoolean("isIp", isIp);
        editor.commit();
    }

    public boolean getIsip() {
        return sp.getBoolean("isIp", false);
    }
}
