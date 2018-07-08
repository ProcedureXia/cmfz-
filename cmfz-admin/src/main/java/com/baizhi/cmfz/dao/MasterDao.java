package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yx on 2018/7/6.
 */
public interface MasterDao {
    public List<Master> selectMasterByPage(@Param("start") int start, @Param("end") int end);

    public int count(@Param("key") String  key,@Param("value") String value);

    public int insertMaster(Master master);

    //批量插入
    public Integer insertMoreMaster(@Param("masters") List<Master> masters);

    public int updateMaster(Master master);

    public List<Master> selectMasterByCondition(@Param("key") String  key,@Param("value") String value,@Param("start") int start, @Param("end") int end);

    public List<Master> selectMasterAll();
}
