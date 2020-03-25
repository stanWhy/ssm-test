package com.why.start.spring.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//使用静态代理
public class Client {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        final Proxy proxy = context.getBean("proxy", Proxy.class);
        proxy.look();proxy.rent();proxy.money();
    }
}
