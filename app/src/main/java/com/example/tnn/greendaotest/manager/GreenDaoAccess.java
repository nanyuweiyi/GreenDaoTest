package com.example.tnn.greendaotest.manager;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * 数据库操作接口实现
 * Created tnn on 16/3/24.
 */
public class GreenDaoAccess<T, K> implements IDBAccess<T, K> {
    private AbstractDao<T, K> dao;

    public GreenDaoAccess(AbstractDao<T, K> dao) {
        this.dao = dao;
    }

    @Override
    public void insert(T entity) {
        dao.insert(entity);
    }

    @Override
    public void insert(Iterable<T> entities) {
        dao.insertInTx(entities);
    }

    @Override
    public void insertOrReplace(T entity) {
        dao.insertOrReplace(entity);
    }

    @Override
    public void insertOrReplaceInTx(Iterable<T> entities) {
        dao.insertOrReplaceInTx(entities);
    }

    @Override
    public List<T> queryAll() {
        return dao.loadAll();
    }

    @Override
    public T query(K key) {
        return dao.load(key);
    }

    @Override
    public List<T> queryRaw(String where, String[] selectionArg) {
        return dao.queryRaw(where, selectionArg);
    }

    @Override
    public QueryBuilder<T> queryBuilder() {
        return dao.queryBuilder();
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteByKey(K key) {
        dao.deleteByKey(key);
    }

    @Override
    public void deleteByKeyInTx(K... keys) {
        dao.deleteByKeyInTx(keys);
    }

    @Override
    public void deleteByKeyInTx(Iterable<K> keys){
        dao.deleteByKeyInTx(keys);
    }

    @Override
    public void deleteInTx(Iterable<T> entities) {
        dao.deleteInTx(entities);
    }

    @Override
    public Long count() {
        return dao.count();
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public void update(Iterable<T> entities) {
        dao.updateInTx(entities);
    }

}
