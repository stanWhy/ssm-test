package com.why.start.spring.dao.impl;

import com.why.start.spring.dao.UserDao;

public class UserDaoImplByLocal implements UserDao {
    @Override
    public void getUser() {
        System.out.println("本地查询");
    }
}
