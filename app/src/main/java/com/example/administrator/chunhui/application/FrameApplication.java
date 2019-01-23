package com.example.administrator.chunhui.application;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class FrameApplication extends MultiDexApplication {
    public static FrameApplication sMFrameApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        sMFrameApplication = this;
    }

    public static Context getContext(){
        return sMFrameApplication.getApplicationContext();
    }

    public static FrameApplication getApplication(){
        return sMFrameApplication;
    }
}
