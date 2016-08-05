package com.lib.mylibrary.base;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * Created by weijinqian on 16/8/5.
 */
public class ActivityManager {
    private static Stack<Activity> activityStack;
    private static ActivityManager instance;

    private ActivityManager() {
    }
    public static ActivityManager getInstance(){
        if (instance==null)
        {
            synchronized (ActivityManager.class){
                if (instance==null){
                    instance=new ActivityManager();
                }
            }
        }
        return instance;
    }

    public void addActivity(Activity activity){
        if (activityStack==null){
            activityStack=new Stack<>();
        }
        activityStack.add(activity);
    }

    public Activity currentActivity(){
        Activity activity=activityStack.lastElement();
        return activity;
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity){
        if(activity!=null){
            activityStack.remove(activity);
            activity.finish();
            activity=null;
        }
    }
    /**
     * 结束指定Class的Activity
     */
    public void finishActivity(Class<?> cls){
        for (Activity activity : activityStack) {
            if(activity.getClass().equals(cls) ){
                finishActivity(activity);
                return;
            }
        }
    }
    /**
     * 结束全部的Activity
     */
    public void finishAllActivity(){
        for (int i = 0, size = activityStack.size(); i < size; i++){
            if (null != activityStack.get(i)){
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
    public void AppExit(Context context){
        try{
            finishAllActivity();
            android.app.ActivityManager activityMgr= (android.app.ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) { }
    }
}
