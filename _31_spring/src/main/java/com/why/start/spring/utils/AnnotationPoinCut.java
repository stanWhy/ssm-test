package com.why.start.spring.utils;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//标注这个类是个切面
@Aspect
public class AnnotationPoinCut {

    @Before("execution(* com.why.start.spring.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("注解 切面 方法前 ");
    }

    @After("execution(* com.why.start.spring.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("注解 切面 方法后");
    }
}
