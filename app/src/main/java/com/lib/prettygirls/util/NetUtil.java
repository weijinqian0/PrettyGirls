package com.lib.prettygirls.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by weijinqian on 16/8/3.
 */
public class NetUtil {
    public NetUtil(){
        throw new UnsupportedOperationException("cannot be constructed");
    }

    public static boolean isConnected(Context context){
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null!=connectivityManager){
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null&&networkInfo.isConnected()){
                if (networkInfo.getState()==NetworkInfo.State.DISCONNECTING){
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean isWifi(Context context){
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null==connectivityManager){
            return false;
        }
        return connectivityManager.getActiveNetworkInfo().getType()==ConnectivityManager.TYPE_WIFI;
    }
    public static void openSetting(Activity activity){
        Intent intent=new Intent("/");
        ComponentName cm = new ComponentName("com.android.settings",
                "com.android.settings.WirelessSettings");
        intent.setComponent(cm);
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent, 0);
    }
}
