package com.mall.dao.item.impl;

import com.mall.dao.item.IItemDao;
import com.mall.orm.item.Item;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by jayson on 2014/8/12.
 */
@Repository("ItemDao")
public class ItemDao implements IItemDao {
    @Resource(name = "HibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public List<Item> list() {
        return hibernateTemplate.find("select id , price , name , category  from Item");
    }

    @Override
    public Serializable save(Item item) {
        return hibernateTemplate.save(item);
    }

    @Override
    public void update(Item item) {
        hibernateTemplate.update(item);
    }

    @Override
    public Item get(int id) {
        return hibernateTemplate.load(Item.class , id);
    }

    @Override
    public void delete(Item item) {
        hibernateTemplate.delete(item);
    }
}
