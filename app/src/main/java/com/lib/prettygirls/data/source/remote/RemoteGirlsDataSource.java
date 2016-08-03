package com.lib.prettygirls.data.source.remote;

import com.lib.prettygirls.data.bean.GirlsBean;
import com.lib.prettygirls.data.source.GirlsDataSource;
import com.lib.prettygirls.http.GirlService;
import com.lib.prettygirls.http.GirlsRetrofit;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by weijinqian on 16/8/2.
 */
public class RemoteGirlsDataSource implements GirlsDataSource {
    @Override
    public void getGirl(LoadGirlCallback callback) {
        getGirls(1, 1, callback);
    }

    @Override
    public void getGirls(int page, int size, final LoadGirlCallback callback) {
        GirlsRetrofit.getRetrofit()
                .create(GirlService.class)
                .getGirls("福利",size,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GirlsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(GirlsBean girlsBean) {
                        callback.onGirlsLoaded(girlsBean);
                    }
                });
    }
}
