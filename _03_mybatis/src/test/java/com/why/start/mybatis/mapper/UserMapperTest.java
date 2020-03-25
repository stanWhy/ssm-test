package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import com.why.start.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void getUserList() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }

    }

    @Test
    public void getUserByLimit() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("startIndex", 0);
            map.put("size", 2);
            final List<User> userByLimit = mapper.getUserByLimit(map);
            for (User user : userByLimit) {
                System.out.println(user);
            }
        }
    }
}