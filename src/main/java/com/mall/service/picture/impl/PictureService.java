package com.mall.service.picture.impl;

import com.mall.dao.picture.IPictureDao;
import com.mall.orm.picture.Picture;
import com.mall.service.picture.IPictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Jayson on 2014/8/19.
 */
@Service("PictureService")
public class PictureService implements IPictureService {
    @Resource(name = "PictureDao")
    private IPictureDao pictureDao;
    @Override
    public Serializable save(Picture picture) {
        return pictureDao.save(picture);
    }
    @Override
    public void saveOrUpdateAll(Collection<Picture> pictures) {
        pictureDao.saveOrUpdateAll(pictures);
    }
}
