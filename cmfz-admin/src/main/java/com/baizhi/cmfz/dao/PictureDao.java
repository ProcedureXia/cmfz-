package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yx on 2018/7/5.
 *
 */
public interface PictureDao {
    public List<Picture> selectPictureByPage(@Param("start") int start, @Param("end") int end);

    public int count();

    public int insertPicture(Picture picture);

    public int updatePicture(Picture picture);
}
