package com.why.start.spring.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

@Service
public class UserServiceImplProxy implements InvocationHandler {

    @Autowired
    private UserService userService;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = new Date().getTime();
        final Object invoke = method.invoke(userService, args);
        long end = new Date().getTime();
        //System.out.println(invoke.getClass());
        System.out.println(method.getName()+"执行了"+(end-start));
        return invoke;
    }

    public Object getProxy(){
        System.out.println("1");
        final Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), userService.getClass().getInterfaces(), this);
        System.out.println("2");
        return o;
    }
}
