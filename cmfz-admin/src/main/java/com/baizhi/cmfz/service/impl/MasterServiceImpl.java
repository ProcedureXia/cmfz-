package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yx on 2018/7/6.
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService{
    @Autowired
    private MasterDao masterDao;

    @Transactional(isolation= Isolation.READ_COMMITTED,propagation= Propagation.SUPPORTS,readOnly=true)
    public Map<String, Object> queryMasterByPage(int nowPage, int pageSize) {
        int start = (nowPage-1)*pageSize;
        int end = pageSize;
        List<Master> list = masterDao.selectMasterByPage(start, end);
        Map<String,Object> map = new HashMap<String ,Object>();
        int count = masterDao.count("","");
        map.put("total",count);
        map.put("rows", list);
        return map;
    }

    @Override
    public int addMaster(Master master) {
        int i = masterDao.insertMaster(master);
        return i;
    }

    @Override
    public List<Master> addMoreMaster(Master master) {
        List<Master> masters = masterDao.insertMoreMaster(master);
        return masters;
    }

    @Override
    public int modifyMaster(Master master) {
        int i = masterDao.updateMaster(master);
        return i;
    }

    @Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.SUPPORTS,readOnly=true)
    public Map<String, Object> queryMasterByCondition(String key, String value, int nowPage, int pageSize) {
        int start = (nowPage-1)*pageSize;
        int end =pageSize;
        List<Master> list = masterDao.selectMasterByCondition(key, value, start, end);
       int count =  masterDao.count(key,value);
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("total",count);
        map.put("rows", list);
        return map;
    }

}
