package com.lib.prettygirls.data.source;

import com.lib.prettygirls.data.bean.GirlsBean;

/**
 * Created by weijinqian on 16/8/2.
 */
public interface GirlsDataSource {
    interface LoadGirlCallback
    {
        void onGirlsLoaded(GirlsBean girlsBean);

        void onDataNotAvailable();
    }
    void getGirls(int page,int size,LoadGirlCallback callback);
    void getGirl(LoadGirlCallback callback);

}
