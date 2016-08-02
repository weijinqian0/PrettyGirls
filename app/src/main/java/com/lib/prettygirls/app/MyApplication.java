package com.lib.prettygirls.app;

import android.app.Application;
import android.content.res.Configuration;

import com.lib.prettygirls.app.exception.LocalFileHandler;
import com.lib.prettygirls.util.LogUtil;
import com.lib.prettygirls.util.ToastUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by weijinqian on 16/7/31.
 */
public class MyApplication extends Application {
    private static MyApplication mApplication;
    public static String currentGirl = "http://ww2.sinaimg.cn/large/610dc034jw1f5k1k4azguj20u00u0421.jpg";

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;
//        配置是否显示Log
        LogUtil.isDebug=true;
//        配置是否显示toast
        ToastUtil.isShow=true;
        Thread.setDefaultUncaughtExceptionHandler(new LocalFileHandler(this));

    }
    public static MyApplication getInstance()
    {
        return mApplication;
    }
    public static OkHttpClient defaultOkHttpClient(){
        OkHttpClient client=new OkHttpClient().newBuilder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3,TimeUnit.SECONDS)
                .readTimeout(3,TimeUnit.SECONDS)
                .build();
        return client;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
