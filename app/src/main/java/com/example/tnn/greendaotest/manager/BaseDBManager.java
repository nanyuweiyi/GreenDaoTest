package com.example.tnn.greendaotest.manager;


import com.example.tnn.greendaotest.MyApp;

/**
 * author: 魏军刚
 * email: weijungang@innobuddy.com
 * date: Created on 16/3/23.
 */
public abstract class BaseDBManager {
    protected MyDB smartDB;

    public void connectDB() {
        smartDB = MyDB.create(MyApp.getUserId());
        initAccess();
    }

    public abstract void initAccess();
}
