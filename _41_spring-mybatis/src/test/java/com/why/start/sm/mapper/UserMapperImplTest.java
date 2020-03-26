package com.why.start.sm.mapper;

import com.why.start.sm.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperImplTest {

    @Test
    public void test(){

        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        //userMapper1


        //final UserMapperImpl userMapper = new UserMapperImpl();
        final List<User> users = userMapper.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

}