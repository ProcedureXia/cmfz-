package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yx on 2018/7/5.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;
    @Transactional(isolation= Isolation.READ_COMMITTED,propagation= Propagation.SUPPORTS,readOnly=true)
    public Map<String, Object> queryPictureByPage(int nowPage, int pageSize) {
        int start = (nowPage-1)*pageSize;
        int end = pageSize;
        List<Picture> list = pictureDao.selectPictureByPage(start, end);
        Map<String,Object> map = new HashMap<String ,Object>();
        int count = pictureDao.count();
        map.put("total",count);
        map.put("rows", list);
        return map;
    }

    @Override
    public int addPicture(Picture picture) {
        int i = pictureDao.insertPicture(picture);
        return i;
    }

    @Override
    public int modifyPicture(Picture picture) {
        int i = pictureDao.updatePicture(picture);
        return i;
    }
}
