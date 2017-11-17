package com.example.tnn.greendaotest.manager;


import com.example.tnn.greendaotest.dao.UserInfo;
import com.example.tnn.greendaotest.dao.UserInfoDao;

import java.util.List;

/**
 * 用户信息操作
 * Created by tnn on 2016/3/28.
 */
public class UserInfoDBManager extends BaseDBManager{

    private static UserInfoDBManager instance;
    private IDBAccess<UserInfo, Long> getuiAccess;

    private UserInfoDBManager() {
    }

    public synchronized static UserInfoDBManager getInstance() {
        if (instance == null) {
            synchronized (UserInfoDBManager.class) {
                if (instance == null) {
                    instance = new UserInfoDBManager();
                }
            }
        }
        instance.connectDB();
        return instance;
    }
    @Override
    public void initAccess() {
        getuiAccess = new GreenDaoAccess<>(smartDB.getSession().getUserInfoDao());
    }

    //查询
    public List<UserInfo> getLastestNotice(int page){
        int offest = page * 10;
        List<UserInfo> lastMsgs = getuiAccess.queryBuilder().where(UserInfoDao.Properties.Name.notEq("张三")).orderDesc(UserInfoDao.Properties.Id).limit(10).offset(offest).list();
        if (lastMsgs == null || lastMsgs.size() <= 0){
            return null;
        }
        return lastMsgs;
    }

    /**
     * 存储
     * @param c
     */
    public void saveGeTuiInfo(UserInfo c){
        getuiAccess.insert(c);
    }

    /**
     * 更改
     * @param g
     */
    public void updataGeTuiRead(UserInfo g){
        getuiAccess.update(g);
    }

}
