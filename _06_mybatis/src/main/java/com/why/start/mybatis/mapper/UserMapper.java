package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
