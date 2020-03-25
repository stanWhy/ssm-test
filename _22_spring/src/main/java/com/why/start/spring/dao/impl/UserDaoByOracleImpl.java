package com.why.start.spring.dao.impl;

import com.why.start.spring.dao.UserDao;

public class UserDaoByOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("从oracle中获取用户数据");
    }
}
