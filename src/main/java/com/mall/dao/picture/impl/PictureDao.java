package com.mall.dao.picture.impl;

import com.mall.dao.picture.IPictureDao;
import com.mall.orm.picture.Picture;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by Jayson on 2014/8/19.
 */
@Repository("PictureDao")
public class PictureDao implements IPictureDao {
    @Resource(name = "HibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public Serializable save(Picture picture) {
        return hibernateTemplate.save(picture);
    }
}
