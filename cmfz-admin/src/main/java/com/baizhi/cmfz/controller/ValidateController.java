package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yx on 2018/7/5.
 */
@Controller
public class ValidateController {
    @RequestMapping("/getVcode")
    public void getValidateCode(HttpSession session, HttpServletResponse response) {
        try {
            CreateValidateCode createValidateCode = new CreateValidateCode(120, 40);
            String vCode = createValidateCode.getCode();
            System.out.println(vCode);
            session.setAttribute("vCode", vCode);
            createValidateCode.write(response.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}