package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.Map;

/**
 * Created by yx on 2018/7/9.
 */
public interface LogService {

    public Map<String,Object> queryLogByPage(int nowPage, int pageSize);

    public Integer addLog(Log log);
}
