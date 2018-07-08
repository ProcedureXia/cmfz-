package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yx on 2018/7/5.
 * @Description 查询所有菜单数据
 */
public interface MenuDao {
    public List<Menu> selectAll();
}
