package com.baizhi.test;

import com.baizhi.cmfz.service.MasterService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by yx on 2018/7/6.
 */
public class MasterTest {

   /* @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MasterService masterService = (MasterService) applicationContext.getBean("masterServiceImpl");
        List<Master> masters = masterService.queryMasterAll();
        for (Master master : masters) {
            System.out.println(master);

        }
    }*/

    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MasterService masterService = (MasterService) applicationContext.getBean("masterServiceImpl");
        Map<String, Object> map = masterService.queryMasterByCondition("masterName", "仁波切", 1, 2);
        for (String s : map.keySet()) {
        System.out.println(s);
        }
    }
}
