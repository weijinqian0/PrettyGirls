package com.lib.prettygirls.data.source;

import com.lib.prettygirls.data.source.Local.LocalGirlsDataSource;
import com.lib.prettygirls.data.source.remote.RemoteGirlsDataSource;

/**
 * Created by weijinqian on 16/8/2.
 */
public class GirlsResponsitory  implements GirlsDataSource{
    private LocalGirlsDataSource mLocalGirlsDataSource;
    private RemoteGirlsDataSource mRemoteGirlsDataSource;

    @Override
    public void getGirls(int page, int size, LoadGirlCallback callback) {
        mRemoteGirlsDataSource.getGirls(page,size,callback);
    }

    @Override
    public void getGirl(LoadGirlCallback callback) {
        mRemoteGirlsDataSource.getGirl(callback);
    }
}
