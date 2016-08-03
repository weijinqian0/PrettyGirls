package com.lib.prettygirls.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import java.io.File;

/**
 * Created by weijinqian on 16/8/3.
 */
public class PhoneUtil {
    private static long lastClickTime;

    public PhoneUtil() {
        throw new UnsupportedOperationException("cannot be constructed");
    }

    /**
     * 调用系统发送短信界面
     * @param antivity
     * @param phoneNumber
     * @param smsContent
     */
    public static void sendMessage(Context antivity,String phoneNumber,String smsContent){
        if (phoneNumber!=null||phoneNumber.length()<4){
            return;
        }
        Uri uri=Uri.parse("smsto:"+phoneNumber);
        Intent it=new Intent(Intent.ACTION_SENDTO,uri);
        it.putExtra("sms_body",smsContent);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        antivity.startActivity(it);
    }

    public static boolean isFastDoubleClick(){
        long time=System.currentTimeMillis();
        long timeD=time-lastClickTime;
        if (0<timeD&&timeD<500){
            return true;
        }
        lastClickTime=time;
        return false;
    }

    /**
     * 获取手机型号
     * @param context
     * @return
     */
    public static String getMobileModule(Context context){
        try {
            String model= Build.MODEL;
            return model;
        }catch (Exception e){
            return "未知";
        }
    }

    /**
     * android 系统版本号
     * @param context
     * @return
     */
    public static String getMobileBrand(Context context){
        try{
            String brand=Build.BRAND;
            return brand;
        }catch (Exception e){
            e.printStackTrace();
            return "未知";
        }
    }

    /**
     * 拍照打开相机
     * @param requestcode
     * @param activity
     * @param fileName
     * @return
     */
    public static void toTakePhoto(int requestcode, Activity activity, String fileName){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra("camerasensortype", 2);// 调用前置摄像头
        intent.putExtra("autofocus", true);// 自动对焦
        intent.putExtra("fullScreen", false);// 全屏
        intent.putExtra("showActionIcons", false);
        try {//创建一个当前任务id的文件然后里面存放任务的照片的和路径！这主文件的名字是用uuid到时候在用任务id去查路径！
            File file = new File(fileName);
            if (!file.exists()) {//如果这个文件不存在就创建一个文件夹！
                file.mkdirs();
            }
            Uri uri = Uri.fromFile(new File(fileName));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            activity.startActivityForResult(intent, requestcode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 打开相册
     *
     * @param requestcode 响应码
     * @param activity    上下文
     */
    public static void toTakePicture(int requestcode, Activity activity) {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*");
        activity.startActivityForResult(intent, requestcode);
    }
}
