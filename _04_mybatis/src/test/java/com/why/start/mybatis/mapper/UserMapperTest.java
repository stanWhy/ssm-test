package com.why.start.mybatis.mapper;

import com.why.start.mybatis.Utils.MybatisUtils;
import com.why.start.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void insertUser() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final int i = mapper.insertUser(new User(13, "INSERT ANNOTATION USER-15", "125896"));
            sqlSession.commit();
            if(i == 1){
                System.out.println("插入正常");
            }
            selectAll();
        }
    }

    @Test
    public void deleteUser() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final int i = mapper.deleteUser(13);
            sqlSession.commit();
            if(i == 1){
                System.out.println("插入正常");
            }
            selectAll();
        }
    }

    @Test
    public void updateUser() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final int i = mapper.updateUser(new User(13, "INSERT ANNOTATION USER-13", "125896"));
            sqlSession.commit();
            if(i == 1){
                System.out.println("插入正常");
            }
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
            final  UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final User user = mapper.selectUserById(1);
            System.out.println(user);
        }
    }
}