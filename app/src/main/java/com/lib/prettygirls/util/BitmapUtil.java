package com.lib.prettygirls.util;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;

import com.lib.prettygirls.app.MyApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by weijinqian on 16/8/2.
 */
public class BitmapUtil {
    public static Bitmap drawableToBitmap(Drawable drawable){
        Bitmap bitmap=Bitmap.createBitmap(
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                drawable.getOpacity()!= PixelFormat.OPAQUE? Bitmap.Config.ARGB_8888: Bitmap.Config.RGB_565
        );
        Canvas canvas=new Canvas(bitmap);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static boolean saveBitmap(Bitmap bitmap,String dir,String name,boolean isShowPhotos){
        File path=new File(dir);
        if (!path.exists()){
            path.mkdirs();
        }
        File file=new File(path+"/"+name);
        if (file.exists())
        {
            file.delete();
        }
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return true;
        }
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (isShowPhotos){
            try {
                MediaStore.Images.Media.insertImage(MyApplication.getInstance().getContentResolver(),
                        file.getAbsolutePath(),name,null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            MyApplication.getInstance().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.parse("file://"+file)));

        }
        return true;

    }
}
