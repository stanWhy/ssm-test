package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    //分页查询
    List<User> getUserByLimit(Map<String,Object> map);
}
