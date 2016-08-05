package com.lib.mylibrary.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by weijinqian on 16/8/5.
 */
public abstract class BaseFragment extends android.support.v4.app.Fragment {
    protected BaseActivity mActivity;

    protected abstract int getLayoutId();
    protected abstract void initView(View view, Bundle savedInstanceState);

    protected BaseActivity getAttachedActivity()
    {
        return mActivity;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity=(BaseActivity) activity;
    }
    protected void addFragment(BaseFragment fragment){
        if (null != fragment) {
            getAttachedActivity().addFragment(fragment);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(getLayoutId(),container,false);
        initView(view, savedInstanceState);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
