package com.baizhi.cmfz.aop;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @description 添加额外功能类
 * Created by yx on 2018/7/9.
 */
@Aspect
public class LogAdvice {

    @Autowired
    private LogDao logDao;

    //基于类型的aop
    @Pointcut("execution(* com.baizhi.cmfz.service.impl..*.modify*(..)) || execution(* com.baizhi.cmfz.service.impl..*add*(..))")
    public void pc(){}

    @Around("pc()")
    public Object log(ProceedingJoinPoint pjp){

            //获取Request
             HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //获取session
            HttpSession session = request.getSession();

            //获取用户
             //Admin user = (Admin) session.getAttribute("admin");
            String adminName= (String) session.getAttribute("adminname");
            //创建新事务对象
            Log log = new Log();
            //获取操作详细信息 message
            String message = "";
            //先获取参数(拼接message)
            Object[] args = pjp.getArgs();
            for (Object o : args) {
                String message1 = args.toString();
                message = message.concat(message1);
            }
            //获取当前的动作(方法名称)
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            Method method = methodSignature.getMethod();
            //根据方法名首字母判断方法类型
            String name = method.getName();
            String fistName = name.substring(0,1);

            if (fistName.equals("a")) {
               log.setAction("添加");
               } else if (fistName.equals("m")) {
               log.setAction("修改");
               } else {
              log.setAction("删除");
               }

                 //获取当前操作资源类型 resource
                String oldName = methodSignature.getDeclaringTypeName();
                String resource = oldName.substring(oldName.lastIndexOf(".")+1) ;
                log.setMessage(message);
                log.setResource(resource);
                //log.setUser(user.getMgrName());
                log.setUser(adminName);
                log.setTime(new Date());

                 //获取状态
                Object obj = null;
                    try{
                        obj = pjp.proceed();
                   log.setResult("success");
                   } catch (Exception e){
                   log.setResult("fail");
                    e.printStackTrace();
                    } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                //System.out.println(log);
               logDao.insertLog(log);
               return obj;


        }

    }
