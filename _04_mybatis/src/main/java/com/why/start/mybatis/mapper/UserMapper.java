package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int insertUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(int id);

    @Update("update user set name=#{name},pwd=#{pwd} where id = #{id}")
    int updateUser(User user);

    @Select("select id ,name ,pwd from user")
    List<User> selectAll();

    @Select("select id,name,pwd from user where id = #{id}")
    User selectUserById(int id);
}
