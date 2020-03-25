package com.why.start.spring.service.impl;

import com.why.start.spring.dao.UserDao;
import com.why.start.spring.service.UserService;

public class UserServiceImplByConstructor implements UserService {

    private UserDao userDao;

    public UserServiceImplByConstructor(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
