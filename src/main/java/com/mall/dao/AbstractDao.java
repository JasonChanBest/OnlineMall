package com.mall.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jayson on 2014/8/19.
 */
public abstract class AbstractDao<T> {
    protected abstract HibernateTemplate getHibernateTemplate();

    public Serializable save(T t){
        return getHibernateTemplate().save(t);
    }

    public void update(T t){
        getHibernateTemplate().update(t);
    }

    public void delete(T t){
        getHibernateTemplate().delete(t);
    }

    public void deleteById(Class<T> clazz , int id){
        T t = getHibernateTemplate().get(clazz, id);
        if(t != null)
            getHibernateTemplate().delete(t);
    }

    public List<T> list(Class<T> clazz){
        return getHibernateTemplate().loadAll(clazz);
    }

    public T get(Class<T> clazz , int id){
        return getHibernateTemplate().get(clazz , id);
    }
}
