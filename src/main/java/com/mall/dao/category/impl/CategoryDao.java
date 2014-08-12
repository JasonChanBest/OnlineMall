package com.mall.dao.category.impl;

import com.mall.dao.category.ICategoryDao;
import com.mall.orm.category.Category;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Jayson on 2014/8/11.
 */
@Repository("CategoryDao")
public class CategoryDao implements ICategoryDao {
    @Resource(name = "HibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public Serializable save(Category category) {
        return hibernateTemplate.save(category);
    }

    @Override
    public List<Category> list() {
        return hibernateTemplate.find("from Category");
    }

    @Override
    public Category get(int id) {
        return hibernateTemplate.get(Category.class , id);
    }

    @Override
    public void delete(Category category) {
        hibernateTemplate.delete(category);
    }

    @Override
    public void update(Category category) {
        hibernateTemplate.update(category);
    }
}
