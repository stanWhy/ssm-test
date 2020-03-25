package com.why.start.spring.pojo;

import com.why.start.spring.ConfigUtils;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {

    @Test
    public void test(){
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigUtils.class);
        final User user = annotationConfigApplicationContext.getBean("getUser", User.class);
        user.setName("wang");
        System.out.println(user.getName());
        user.getDog();
    }

}