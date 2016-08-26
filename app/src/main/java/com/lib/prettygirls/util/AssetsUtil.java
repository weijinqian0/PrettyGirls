package com.lib.prettygirls.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.lib.prettygirls.app.MyApplication;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by weijinqian on 16/8/26.
 */
public class AssetsUtil {
    private AssetsUtil(){
        throw new UnsupportedOperationException("cannot be constructed by construct method");
    }
    private Context context= MyApplication.getInstance().getApplicationContext();
    public Bitmap getBitmapFromAssets(String name){
        AssetManager assetManager=context.getResources().getAssets();
        InputStream inputStream= null;
        Bitmap bitmap=null;
        try {
            inputStream = assetManager.open(name);
            bitmap= BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (inputStream!=null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return bitmap;
    }
}
