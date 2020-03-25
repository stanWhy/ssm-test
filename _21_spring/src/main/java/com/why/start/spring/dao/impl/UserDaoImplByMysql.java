package com.why.start.spring.dao.impl;

import com.why.start.spring.dao.UserDao;

public class UserDaoImplByMysql implements UserDao {
    @Override
    public void getUser() {
        System.out.println("mysql中查询");
    }
}
