package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.service.PictureService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yx on 2018/7/5.
 */
@Controller
public class MasterController {
    @Autowired
    private MasterService masterService;

    @RequestMapping("/queryAllMaster")
    @ResponseBody
    public Map<String,Object>  queryMasterByPage(@RequestParam("page") int nowPage, @RequestParam("rows") int pageSize){
        Map<String, Object> map = masterService.queryMasterByPage(nowPage, pageSize);
        return map;
    }

    @RequestMapping("/addMaster")
    @ResponseBody
    public String addMaster(Master master, MultipartFile file, HttpSession session) throws IOException {
        //生成唯一的UUID文件名
        String uuidName = UUID.randomUUID().toString().replace("-","");
        //源文件名
        String oldName = file.getOriginalFilename();
        //获取后缀
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //添加数据库的操作
        master.setMasterPhoto(uuidName+suffix);
        Integer i = masterService.addMaster(master);
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

    @RequestMapping("/modifyMaster")
    @ResponseBody
    public String modifyMaster(Master master){
        int i = masterService.modifyMaster(master);
        if(i>0){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/queryMasterByKey")
    @ResponseBody
    public Map<String,Object> queryMasterByKey(String key,String value,@RequestParam("page")int nowPage,@RequestParam("rows")int pageSize ) {
        Map<String, Object> map = masterService.queryMasterByCondition(key, value, nowPage, pageSize);
     //   System.out.println("00000000000000000000000"+map);
        return map;
    }


    @RequestMapping("/addBatch")
    @ResponseBody
    public String importExcel(MultipartFile file){

        //参数1:输入流
        //参数2:pojo
        //参数3:导入参数对象
        try {
        ImportParams params = new ImportParams();
        List<Master> masters = ExcelImportUtil.importExcel(file.getInputStream(),Master.class,params);
            for (Master master : masters) {
                System.out.println(master);
            }
            masterService.addMoreMaster(masters);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }


    /**
     * 注意事项：下载文件的时候不能使用异步请求 ajax
     *
     * dataType:json
     *          xml
     *          不支持stream类型
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Master> masters  = masterService.queryMasterAll();
        //Excel文件
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("上师表","上师信息.xls"),Master.class,masters);

        ServletOutputStream out = response.getOutputStream();

        //文件下载
        //注意:响应头 默认使用的编码格式为iso-8859-1

        //设置文件名
        String fileName = new String("上师信息");
        //设置响应类型
        response.setContentType("application/vnd.ms-excel");
        //设置响应头
        response.setHeader("context-disposition","attachment;fileName"+fileName);

        //导出文件方式
        workbook.write(out);
        out.close();
    }
}