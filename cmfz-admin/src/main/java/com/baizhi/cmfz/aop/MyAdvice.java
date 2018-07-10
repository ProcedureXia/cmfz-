package com.baizhi.cmfz.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 额外功能类  记录日志信息
 * Created by yx on 2018/7/9.
 */
@Component
@Aspect
public class MyAdvice {

    /*@Autowired
    public void setSession(HttpSession session){
        this.session = session;
    }*/


    /**
     * 声明切入点表达式
     */
    //@Pointcut("execution((* com.baizhi.cmfz.*.*(..))")

    //基于类型的aop
    @Pointcut("execution(* com.baizhi.cmfz.service.impl..*.modify*(..)) || execution(* com.baizhi.cmfz.service.impl..*add*(..))")
    public void pc(){}



    /**
     * 前置通知方法
     */
    @Before("pc()") // 标示当前的前置通知使用pc方法上声明的切入点表达式
    public void before(){
        System.out.println("----------------前置通知------------");
    }

    /**
     * 后置通知方法
     */
    @AfterReturning("pc()")
    public void after(){
        System.out.println("----------------后置通知------------");
    }


    @AfterThrowing("pc()")
    public void afterThrowing(){
        System.out.println("-------------出现异常--------------");
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {  // 连接点
        //获取当前的参数信息
        Object[] args = pjp.getArgs();
        System.out.println(args[0]);

        //获取当前的动作(方法名称)
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        //获取当前方法上的注解(自定义注解)
        /*Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }*/

        //获取当前操作时间

        //获取当前操作资源类型

        //获取操作详细信息

        System.out.println("----------------环绕前------------");

        // 调用传递
        // obj 原始方法的返回值
        //获取当前操作结果
        String result = null;
        Object obj = null;
        try {
            obj = pjp.proceed();
            result = "success";
        } catch (Throwable throwable) {
            result = "fail";
            throwable.printStackTrace();
        }
        System.out.println("advice: "+obj);
        System.out.println("----------------环绕后------------");
        return obj;
    }
}
