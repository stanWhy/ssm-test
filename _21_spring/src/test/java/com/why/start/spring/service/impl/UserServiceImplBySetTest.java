package com.why.start.spring.service.impl;

import com.why.start.spring.dao.impl.UserDaoImplByOracle;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplBySetTest {

    @Test
    public void getUser() {
        final UserServiceImplBySet userServiceImplBySet = new UserServiceImplBySet();
        userServiceImplBySet.setUserService(new UserDaoImplByOracle());
        userServiceImplBySet.getUser();
    }
}