package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Data;
import com.baizhi.cmfz.entity.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yx on 2018/7/9.
 */

@Controller
public class UserController {

    @RequestMapping("/peopleCharts")
    @ResponseBody
    public List<People> peopleCharts(){
        List<People> people = new ArrayList<People>();
        people.add(new People("北京",100));
        people.add(new People("天津" , 300));
        people.add(new People( "上海", 100));
        people.add(new People("重庆", 100));
        people.add(new People("河北",1000));
        people.add(new People("河南",1800));
        people.add(new People("云南",100));
        people.add(new People("辽宁",500));
        people.add(new People("黑龙江",1100));
        people.add(new People("湖南",100));
        people.add(new People("安徽",100));
        people.add(new People("山东",500));
        people.add(new People("新疆",100));
        people.add(new People("江苏",100));
        people.add(new People("浙江",100));
        people.add(new People("江西",600));
        people.add(new People("湖北",100));
        people.add(new People("广西",400));
        people.add(new People("甘肃",200));
        people.add(new People("山西",100));
        people.add(new People("内蒙古",900));
        people.add(new People("陕西",1000));
        people.add(new People("吉林",1000));
        people.add(new People("福建",1000));
        people.add(new People("贵州",1000));
        people.add(new People("广东",1100));
        people.add(new People("青海",1000));
        people.add(new People("西藏",1000));
        people.add(new People("海南",1000));
        people.add(new People("香港",300));
        people.add(new People("澳门",300));
        people.add(new People("台湾",100));

        return people;
    }

    @RequestMapping("/activeUser")
    @ResponseBody
    public Data activeUser() {
        List<String> sex = new ArrayList<String>();
        List<Integer> counts = new ArrayList<Integer>();
        sex.add("男");
        counts.add(100);
        sex.add("女");
        counts.add(150);
        return new Data(sex,counts);
    }
}
