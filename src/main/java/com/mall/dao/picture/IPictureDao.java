package com.mall.dao.picture;

import com.mall.orm.picture.Picture;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Jayson on 2014/8/19.
 */
public interface IPictureDao {
    public Serializable save(Picture picture);
    public void saveOrUpdateAll(Collection<Picture> pictures);

}
