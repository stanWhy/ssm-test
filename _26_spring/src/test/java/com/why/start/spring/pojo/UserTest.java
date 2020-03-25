package com.why.start.spring.pojo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void test(){
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        final User user = context.getBean("user", User.class);
        System.out.println(user.getName());
        user.getDog().shot();
    }

}