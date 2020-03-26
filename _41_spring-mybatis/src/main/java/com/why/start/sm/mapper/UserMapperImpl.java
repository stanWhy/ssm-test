package com.why.start.sm.mapper;

import com.why.start.sm.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<User> selectUsers() {
        final UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        final List<User> users = mapper.selectUsers();
        return users;
    }
}
