package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

/**
 * Created by yx on 2018/7/9.
 */
@Controller
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/queryAllLog")
    @ResponseBody
    public Map<String,Object>  queryLogByPage(@RequestParam("page") int nowPage, @RequestParam("rows") int pageSize){
        Map<String, Object> map = logService.queryLogByPage(nowPage, pageSize);
        return map;
    }


    @RequestMapping("/addLog")
    public String addLog(Log log){
        Integer integer = logService.addLog(log);
        return null;
    }

}