package com.why.start.spring.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Service
//用这个类自动生成代理类
public class Proxy2 implements InvocationHandler {

    @Autowired
    private Rent2 rent2;

    //处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final Object invoke = method.invoke(rent2, args);

        return invoke;
    }

    //生成代理类
    public Object getProxy(){
        before();
        System.out.println("o  before");
        final Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), rent2.getClass().getInterfaces(), this);
        after();
        return o;
    }

    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }
}
