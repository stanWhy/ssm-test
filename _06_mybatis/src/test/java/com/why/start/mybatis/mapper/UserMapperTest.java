package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import com.why.start.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void test() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final List<User> users = mapper.selectAll();
            for (User user : users) {
                System.out.println(user);
            }
        }

    }

}