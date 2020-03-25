package com.why.start.spring.dao.impl;

import com.why.start.spring.dao.UserDao;

public class UserDaoImplByOracle implements UserDao {
    @Override
    public void getUser() {
        System.out.println("oracel中查询");
    }
}
