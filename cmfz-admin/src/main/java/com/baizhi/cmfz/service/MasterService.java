package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

/**
 * Created by yx on 2018/7/6.
 */
public interface MasterService {

    public Map<String,Object> queryMasterByPage(int nowPage, int pageSize);

    public int addMaster(Master master);

    public List<Master> addMoreMaster(Master master);

    public int modifyMaster(Master master);

    public Map<String,Object> queryMasterByCondition(String key,String value,int nowPage,int pageSize);

}
