package com.why.start.spring.demo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//使用动态代理
public class Client2 {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        final Proxy2 proxy2 = context.getBean("proxy2", Proxy2.class);
        Rent2 proxy = (Rent2) proxy2.getProxy();
        //proxy.
        proxy.rent();

    }
}
