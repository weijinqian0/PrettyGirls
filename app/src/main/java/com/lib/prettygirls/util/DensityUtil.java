package com.lib.prettygirls.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by weijinqian on 16/8/2.
 */
public class DensityUtil {
    public DensityUtil(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static int dp2px(Context context,float dpval){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpval,
                context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context,float spval){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,spval,
                context.getResources().getDisplayMetrics());
    }

    public static float px2dp(Context context,float pxval){
        final float scale=context.getResources().getDisplayMetrics().density;
        return pxval/scale;
    }

    public static float px2sp(Context context,float pxval){
        final float scale=context.getResources().getDisplayMetrics().scaledDensity;
        return pxval/scale;
    }
}
