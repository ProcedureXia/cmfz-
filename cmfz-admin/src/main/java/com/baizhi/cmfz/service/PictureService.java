package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.Map;

/**
 * Created by yx on 2018/7/5.
 * * 分页查询
 * @return
 */
public interface PictureService {
    public Map<String,Object> queryPictureByPage(int nowPage, int pageSize);

    public int addPicture(Picture picture);

    public int modifyPicture(Picture picture);
}
