package com.example.tnn.greendaotest;

import android.app.Application;
import android.content.Context;

/**
 * Application类
 * Created by tnn on 2016/6/13.
 */
public class MyApp extends Application{

    private static Context mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = this;

        initSmartDB();
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return mApplicationContext;
    }

    public static void initSmartDB(){
        Runnable createDBTask = new Runnable() {
            @Override
            public void run() {
//                MyDB.create();
            }
        };
        createDBTask.run();
    }

    public static int getUserId() {
        return 0;
    }
}
