package com.mall.service.category.impl;

import com.mall.dao.category.ICategoryDao;
import com.mall.orm.category.Category;
import com.mall.service.category.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Jayson on 2014/8/11.
 */
@Service("CategoryService")
public class CategoryService implements ICategoryService {
    @Resource(name = "CategoryDao")
    private ICategoryDao categoryDao;
    @Override
    public Serializable save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public List<Category> list() {
        return categoryDao.list();
    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }
}
