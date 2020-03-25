package com.why.start.spring.demo3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//动态代理
public class Client3 {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        final UserServiceImplProxy userServiceImplProxy = context.getBean("userServiceImplProxy", UserServiceImplProxy.class);
        UserService proxy = (UserService) userServiceImplProxy.getProxy();
        proxy.add();
        proxy.del();
    }
}
