package com.lib.prettygirls.http;

import com.lib.prettygirls.data.bean.GirlsBean;

import rx.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by weijinqian on 16/8/2.
 */
public interface GirlService {
    @GET("api/data/{type}/{count}/{page}")
    Observable<GirlsBean> getGirls(
            @Path("type") String path,
            @Path("count") int count,
            @Path("page") int page
    );
}
