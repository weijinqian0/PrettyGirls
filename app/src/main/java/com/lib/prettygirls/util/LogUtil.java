package com.lib.prettygirls.util;

import android.util.Log;

/**
 * Created by weijinqian on 16/8/2.
 */
public class LogUtil {
    private  LogUtil() {
        throw new UnsupportedOperationException("cannnot be instantiated");
    }

    public static boolean isDebug=true;
    private static final String Tag="LogUtil";

    public static void i(String msg){
        if (isDebug)
        {
            Log.i(Tag,msg);
        }
    }
    public static void d(String msg){
        if (isDebug)
        {
            Log.d(Tag,msg);
        }
    }
    public static void e(String msg){
        if (isDebug)
        {
            Log.e(Tag,msg);
        }
    }
    public static void v(String msg){
        if (isDebug)
        {
            Log.v(Tag,msg);
        }
    }

//    下面是自定义tag
    public static void i(String tag,String msg){
        if (isDebug){
            Log.i(tag,msg);
        }
    }
    public static void d(String tag,String msg){
        if (isDebug){
            Log.d(tag,msg);
        }
    }
    public static void e(String tag,String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }
    public static void v(String tag,String msg){
        if (isDebug){
            Log.v(tag,msg);
        }
    }

}
