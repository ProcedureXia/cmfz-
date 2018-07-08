package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by yx on 2018/7/5.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/login")
    public String login(Admin admin, String enCode, HttpSession session, String rememberMe, HttpServletResponse response) throws UnsupportedEncodingException {
        String vCode = (String) session.getAttribute("vCode");
        if(vCode.equalsIgnoreCase(enCode)) {
            Admin currentAdmin = adminService.login(admin);
            //!!!存到作用域中
            session.setAttribute("admin",currentAdmin);
            if(currentAdmin == null) {
                return "redirect:/login.jsp";
            }
           if(rememberMe !=null){
               String adminName =  admin.getMgrName();
               String encode = URLEncoder.encode(adminName,"UTF-8");
               Cookie cookie = new Cookie("cookieName",encode);
               cookie.setMaxAge(60*60*24*7);
               response.addCookie(cookie);
           }
            return "redirect:/main.jsp";

        } else {
            return "redirect:/login.jsp";
        }

    }
}
