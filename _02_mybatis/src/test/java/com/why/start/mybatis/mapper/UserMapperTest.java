package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import com.why.start.mybatis.utis.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void insertUser() {
        User user = new User(12,"USER-A","7896321");
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final int i = mapper.insertUser(user);
            if (i == 1) {
                System.out.println("插入成功");
            }
            sqlSession.commit();
        }
        selectAll();
    }

    @Test
    public void deleteUserById() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final int i = mapper.deleteUserById(12);
            if (i == 1) {
                System.out.println("删除成功");
            }
            sqlSession.commit();
        }
        selectAll();
    }

    @Test
    public void updateUser() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final int i = mapper.updateUser(new User(11, "USER-UPDATE-A", "14785236"));
            if (i == 1) {
                System.out.println("修改成功");
            }
            sqlSession.commit();
            selectAll();
        }
    }

    @Test
    public void selectAll() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final List<User> users = mapper.selectAll();
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void selectUserById() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final User user = mapper.selectUserById(1);
            System.out.println(user);
        }
    }
}
