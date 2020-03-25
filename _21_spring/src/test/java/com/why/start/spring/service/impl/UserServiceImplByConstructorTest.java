package com.why.start.spring.service.impl;

import com.why.start.spring.dao.impl.UserDaoImplByMysql;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplByConstructorTest {

    @Test
    public void getUser() {
        new UserServiceImplByConstructor(new UserDaoImplByMysql()).getUser();
    }
}