package com.why.start.sm.mapper;

import com.why.start.sm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {


    @Test
    public void test() throws IOException {
        final SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        final List<User> users = mapper.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

}