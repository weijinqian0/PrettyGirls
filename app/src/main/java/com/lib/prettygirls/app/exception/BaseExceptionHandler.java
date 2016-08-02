package com.lib.prettygirls.app.exception;

import java.text.DateFormat;
import java.lang.Thread.UncaughtExceptionHandler;

/**
 * Created by weijinqian on 16/7/31.
 */
public abstract class BaseExceptionHandler implements UncaughtExceptionHandler {
    public static final String TAG="CrashHandler";
    public static final DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
    public BaseExceptionHandler() {

    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if(handleException(ex))
        {
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    public abstract boolean handleException(Throwable ex);
}
