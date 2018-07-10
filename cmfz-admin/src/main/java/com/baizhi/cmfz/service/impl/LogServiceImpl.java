package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import com.baizhi.cmfz.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yx on 2018/7/9.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Transactional(isolation= Isolation.READ_COMMITTED,propagation= Propagation.SUPPORTS,readOnly=true)
    public Map<String, Object> queryLogByPage(int nowPage, int pageSize) {
        int start = (nowPage-1)*pageSize;
        int end = pageSize;
        List<Log> list = logDao.selectLogByPage(start, end);
        Map<String,Object> map = new HashMap<String ,Object>();
        int count = logDao.count();
        map.put("total",count);
        map.put("rows", list);
        return map;
    }

    @Override
    public Integer addLog(Log log) {
        Integer i= logDao.insertLog(log);
        return i;
    }
}
