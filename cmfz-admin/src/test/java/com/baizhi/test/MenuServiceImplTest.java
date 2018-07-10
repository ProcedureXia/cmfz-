package com.baizhi.test;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.service.MenuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by yx on 2018/7/5.
 */
public class MenuServiceImplTest {
    @Test
    public void test1(){
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuService menuService = (MenuService) applicationContext.getBean("menuServiceImpl");
        List<Menu> list = menuService.queryAll();
        for (Menu menu : list) {
            System.out.println(menu);

        }
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
       MasterService ms = (MasterService) applicationContext.getBean("masterServiceImpl");
        Map<String, Object> map = ms.queryMasterByPage(1, 2);
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }
}
