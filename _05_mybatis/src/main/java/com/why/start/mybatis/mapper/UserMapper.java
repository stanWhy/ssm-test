package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insertUser(User user);

    int deleteUserById(@Param("id") int id);

    int updateUser(User user);

    List<User> selectAll();

    User selectUserById(@Param("id") int id);
}
