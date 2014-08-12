package com.mall.dao.item;

import com.mall.orm.item.Item;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jayson on 2014/8/12.
 */
public interface IItemDao {
    public List<Item> list();
    public Serializable save(Item item);
    public void update(Item item);
    public Item get(int id);
    public void delete(Item item);
}
