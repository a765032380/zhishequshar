package com.bjxiyangshar.myapplication.app;

import android.app.Application;
import android.content.Context;


/**
 * Created by sander on 2017/4/7.
 */

public class GuardApplication extends Application {

    /**
     * 是否加密数据库.
     */
   
    public static Context applicationContext;


    public static GuardApplication instance;

    public GuardApplication(){
        instance = this;
    }

    public static GuardApplication getContent(){
        return instance;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        instance = this;
    }
}
