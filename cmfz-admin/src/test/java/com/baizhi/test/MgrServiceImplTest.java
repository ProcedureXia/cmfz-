package com.baizhi.test;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yx on 2018/7/12.
 */
public class MgrServiceImplTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AdminService adminService= (AdminService) applicationContext.getBean("adminServiceImpl");
        Admin admin = new Admin();
        admin.setMgrId(2);
        admin.setMgrName("ls");
        admin.setMgrPassword("f48edd4c8cdc37e2c5dad0297ab75e3f");
        admin.setSalt("xyz");
        admin.setMgrStatus("1");
        Admin login = adminService.login(admin);
        System.out.println(login);
    }
}
