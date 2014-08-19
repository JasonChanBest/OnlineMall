package com.mall.dao.category.impl;

import com.mall.dao.category.AbstractCategoryDao;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Jayson on 2014/8/11.
 */
@Repository("CategoryDao")
public class CategoryDao extends AbstractCategoryDao {
    @Resource(name = "HibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Override
    protected HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
}
