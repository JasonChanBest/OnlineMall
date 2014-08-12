package com.mall.dao.category;

import com.mall.orm.category.Category;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jayson on 2014/8/11.
 */
public interface ICategoryDao {
    public Serializable save(Category category);
    public List<Category> list();
    public Category get(int id);
    public void delete(Category category);
    public void update(Category category);
}
