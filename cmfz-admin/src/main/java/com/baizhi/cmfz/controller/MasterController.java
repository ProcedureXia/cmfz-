package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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


    @RequestMapping(value="/importExcel",method= RequestMethod.POST)
    @ResponseBody
    public void importExcel(MultipartFile file , HttpServletRequest request) throws IOException {

        ImportParams params = new ImportParams();
        //设置表格标题
        params.setTitleRows(0);
        //表头函数
        params.setHeadRows(1);

        //是否上传保存到Excel
        params.setNeedSave(true);

        String path = request.getSession().getServletContext().getRealPath("");

        System.out.println(path);

        File f = new File(path +"/excel"+file.getOriginalFilename());
        if(!f.exists()){
            File dir = new File(path+"/excel");
            dir.mkdir();
            if(f.createNewFile()){
                System.out.println("创建文件成功");
            }else{
                System.out.println("创建文件失败");
            }
        }
        file.transferTo(f);//将上传文件写到服务器指定文件
        List<Master> masters = ExcelImportUtil.importExcel(f,Master.class,params);
        System.out.println(JSON.toJSONString(masters));

    }
}