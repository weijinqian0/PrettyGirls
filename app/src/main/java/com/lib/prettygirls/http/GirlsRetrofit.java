package com.lib.prettygirls.http;

import com.lib.prettygirls.app.Constants;
import com.lib.prettygirls.app.MyApplication;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by weijinqian on 16/8/2.
 */
public class GirlsRetrofit {
    private static Retrofit retrofit;
    public static Retrofit getRetrofit()
    {
        if (retrofit==null)
        {
            synchronized (retrofit)
            {
                if (retrofit==null)
                {
                    retrofit=new Retrofit.Builder()
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(Constants.GANHUO_API)
                            .client(MyApplication.defaultOkHttpClient())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
