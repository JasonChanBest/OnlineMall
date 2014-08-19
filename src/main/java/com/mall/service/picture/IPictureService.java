package com.mall.service.picture;

import com.mall.orm.picture.Picture;

import java.io.Serializable;

/**
 * Created by Jayson on 2014/8/19.
 */
public interface IPictureService {
    public Serializable save(Picture picture);
}
