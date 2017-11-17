package com.example.tnn.greendaotest.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tnn.greendaotest.util.Md5Utils;
import com.example.tnn.greendaotest.MyApp;
import com.example.tnn.greendaotest.dao.DaoMaster;
import com.example.tnn.greendaotest.dao.DaoSession;
import com.example.tnn.greendaotest.dao.UserInfoDao;
import com.example.tnn.greendaotest.util.UpdateUtil;

public class MyDB {

    private static MyDB instance;

    /** 数据库统一后缀名 */
    private static final String DATABASE_NAME_SUFFIX = "_user.db";

    /** 数据库版本 */
    public static final int VERSION = 5;

    private SmartSQLiteHelper helper;

    public static SQLiteDatabase db;

    private DaoMaster master;

    private DaoSession session;

    public void open(String userInfo) {
        String name = userInfo + DATABASE_NAME_SUFFIX;
        helper = new SmartSQLiteHelper(MyApp.getContext(), name, null);
        db = helper.getWritableDatabase();
        master = new DaoMaster(db);
        session = master.newSession();
    }

    /**
     * 创建用户数据库
     */
    public synchronized static MyDB create(int userId) {
        if (instance == null) {
            instance = new MyDB();
            String userIndo = Md5Utils.encode(String.valueOf(userId));
            instance.open(userIndo);
        }
        return instance;
    }

    public void close() {
        if (helper != null) {
            helper.close();
        }
        helper = null;
        session = null;
    }

    public DaoSession getSession() {
        return session;
    }

    static class SmartSQLiteHelper extends SQLiteOpenHelper {

        public SmartSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            DaoMaster.createAllTables(db, false);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.e("*********", oldVersion+"---"+newVersion);
            if(oldVersion < newVersion){
                UpdateUtil.getInstance().migrate(db, UserInfoDao.class);
            }
        }

    }
}

