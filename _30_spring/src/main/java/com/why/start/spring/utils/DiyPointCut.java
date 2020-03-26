package com.why.start.spring.utils;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class DiyPointCut {
    public void before(){
        System.out.println("方法前执行");
    }
    public void after(){
        System.out.println("方法后执行");
    }

}
