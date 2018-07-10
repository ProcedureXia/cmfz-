package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yx on 2018/7/8.
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/queryAllArticle")
    @ResponseBody
    public Map<String,Object> queryArticleByPage(@RequestParam("page") int nowPage, @RequestParam("rows") int pageSize){
        Map<String, Object> map = articleService.queryArticleByPage(nowPage, pageSize);
        //System.out.println(map);
        return map;
    }

    @RequestMapping("/addPic")
    @ResponseBody
    public RichTextResult uploadPic(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException {
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0, realPath.lastIndexOf("\\")) + "\\upload";
            if (files != null && files.length != 0) {
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString().replace("-","")+ "." + FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath + "\\" + fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath() + "/upload/" + fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/addArticle")
    @ResponseBody
    public String addArticle(Article article,String masterId){
        //System.out.println(article);
        //System.out.println(masterId);
        article.setArticleDate(new Date());
        articleService.addArticle(article);
        return null;
    }

}
