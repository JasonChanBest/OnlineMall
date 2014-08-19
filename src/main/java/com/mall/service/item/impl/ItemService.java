package com.mall.service.item.impl;

import com.mall.dao.item.AbstractItemDao;
import com.mall.orm.item.Item;
import com.mall.service.item.IItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Jayson on 2014/8/19.
 */
@Service("ItemService")
public class ItemService implements IItemService {

    @Resource(name = "ItemDao")
    private AbstractItemDao itemDao;

    @Override
    public List<Item> list() {
        return itemDao.list(Item.class);
    }

    @Override
    public Serializable save(Item item) {
        return itemDao.save(item);
    }

    @Override
    public void update(Item item) {
        itemDao.update(item);
    }

    @Override
    public Item get(int id) {
        return itemDao.get(Item.class , id);
    }

    @Override
    public void delete(Item item) {
        itemDao.delete(item);
    }
}
