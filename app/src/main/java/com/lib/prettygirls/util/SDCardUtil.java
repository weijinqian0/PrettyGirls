package com.lib.prettygirls.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by weijinqian on 16/8/3.
 */
public class SDCardUtil {
    public SDCardUtil() {
        throw new UnsupportedOperationException("cannot be constructed");
    }

    /**
     * 判断是否有SD卡
     * @return
     */
    public static boolean isSDCardEnable(){
        return Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * SD卡的路径
     * @return
     */
    public static String getSDCardPath(){
        return Environment.getExternalStorageDirectory().getAbsolutePath()+ File.pathSeparator;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getSDCardSize(){
        if (isSDCardEnable()){
            StatFs statFs=new StatFs(getSDCardPath());
            long availableBlocks=(long)statFs.getAvailableBlocksLong()-4;
            long blockSizes=(long)statFs.getBlockSizeLong();
            return blockSizes*availableBlocks;
        }
        return 0;
    }
    /**
     * 获取指定路径所在空间的剩余可用容量字节数，单位byte
     *
     * @param filePath
     * @return 容量字节 SDCard可用空间，内部存储可用空间
     */
    public static long getFreeBytes(String filePath) {
        // 如果是sd卡的下的路径，则获取sd卡可用容量
        if (filePath.startsWith(getSDCardPath())) {
            filePath = getSDCardPath();
        } else {
            // 如果是内部存储的路径，则获取内存存储的可用容量
            filePath = Environment.getDataDirectory().getAbsolutePath();
        }
        StatFs stat = new StatFs(filePath);
        long availableBlocks = (long) stat.getAvailableBlocks() - 4;
        return stat.getBlockSize() * availableBlocks;
    }

    /**
     * 获取系统存储路径
     *
     * @return
     */
    public static String getRootDirectoryPath() {
        return Environment.getRootDirectory().getAbsolutePath();
    }

}
