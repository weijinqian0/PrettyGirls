package com.lib.prettygirls.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by weijinqian on 16/8/2.
 */
public class AppUtil {
    private AppUtil()
    {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static String getAppName(Context context)
    {
        PackageManager packageManager=context.getPackageManager();
        try {
            PackageInfo packageInfo=packageManager.getPackageInfo(context.getPackageName(),0);
            int labelRes=packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static String getVersionName(Context context){
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int getVersionCode(Context context){
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
