package com.mall.dao.item.impl;

import com.mall.dao.item.AbstractItemDao;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Jayson on 2014/8/19.
 */
@Repository("ItemDao")
public class ItemDao extends AbstractItemDao {

    @Resource(name = "HibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Override
    protected HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
}
