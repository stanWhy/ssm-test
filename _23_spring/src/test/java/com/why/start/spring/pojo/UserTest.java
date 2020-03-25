package com.why.start.spring.pojo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void show() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        final User user = context.getBean("user", User.class);
        System.out.println(user);
        user.show();
        System.out.println("=============");
        final User user2 = context.getBean("user2", User.class);
        System.out.println(user2);
        user2.show();
        System.out.println("================");
        final User user3 = context.getBean("user3", User.class);
        System.out.println(user3);
        user3.show();
    }
}