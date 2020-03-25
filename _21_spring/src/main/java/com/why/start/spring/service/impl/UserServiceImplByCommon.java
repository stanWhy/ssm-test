package com.why.start.spring.service.impl;

import com.why.start.spring.dao.UserDao;
import com.why.start.spring.dao.impl.UserDaoImplByLocal;
import com.why.start.spring.dao.impl.UserDaoImplByMysql;
import com.why.start.spring.dao.impl.UserDaoImplByOracle;
import com.why.start.spring.service.UserService;

/**
 * 普通new对象的方式，耦合度高
 */
public class UserServiceImplByCommon implements UserService {
    @Override
    public void getUser() {
        UserDao userDao = new UserDaoImplByLocal();
        userDao.getUser();
        userDao = new UserDaoImplByMysql();
        userDao.getUser();
        userDao = new UserDaoImplByOracle();
        userDao.getUser();
    }
}
