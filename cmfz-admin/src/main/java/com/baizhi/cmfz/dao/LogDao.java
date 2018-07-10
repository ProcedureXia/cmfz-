package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by yx on 2018/7/9.
 */
public interface LogDao {
    public List<Log> selectLogByPage(@Param("start") int start, @Param("end") int end);

    public int count();

    public Integer insertLog(Log log);
}
