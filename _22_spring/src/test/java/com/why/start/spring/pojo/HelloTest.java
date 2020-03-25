package com.why.start.spring.pojo;

import com.why.start.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class HelloTest {

    @Test
    public void getStr() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        final Hello hello = context.getBean("hello", Hello.class);

        System.out.println(hello.getStr());
    }
}