package com.why.start.spring.service.impl;

import com.why.start.spring.dao.UserDao;
import com.why.start.spring.service.UserService;

public class UserServiceImplBySet implements UserService {

    private UserDao userDao;
    public void setUserService(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
