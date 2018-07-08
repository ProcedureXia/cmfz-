package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yx on 2018/7/5.
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/queryAllPicture")
    @ResponseBody
    public Map<String,Object>  queryPictureByPage(@RequestParam("page") int nowPage, @RequestParam("rows") int pageSize){
        Map<String, Object> map = pictureService.queryPictureByPage(nowPage, pageSize);
        System.out.println(map);
        return map;
    }

    @RequestMapping("/addPicture")
    @ResponseBody
    public String addPicture(Picture picture, MultipartFile file,HttpSession session) throws IOException {
     //轮播图创建时间
        picture.setCreateTime(new Date());

        //生成唯一的UUID文件名
        String uuidName = UUID.randomUUID().toString().replace("-","");
        //源文件名
        String oldName = file.getOriginalFilename();
        //获取后缀
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //添加数据库的操作
        picture.setPictureName(uuidName+suffix);
        Integer i = pictureService.addPicture(picture);
        if(i==1){
            //添加成功,将图片放进文件中
            String realPath = session.getServletContext().getRealPath("/");
//            System.out.println(realPath);
            String[] strings = realPath.split("ROOT");
            String uploadPath = strings[0]+"upload";//文件上传的路径
//            System.out.println(uploadPath+"//"+file.getOriginalFilename());
            file.transferTo(new File(uploadPath+"/"+uuidName+suffix));
        }
        return null;
    }

    @RequestMapping("/modifyPicture")
    @ResponseBody
    public String modifyPicture(Picture picture){
        int i = pictureService.modifyPicture(picture);
        if(i>0){
            return "success";
        }else{
            return "error";
        }
    }
}