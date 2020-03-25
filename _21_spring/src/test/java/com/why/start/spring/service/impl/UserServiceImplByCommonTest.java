package com.why.start.spring.service.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplByCommonTest {

    @Test
    public void getUser() {
        new UserServiceImplByCommon().getUser();
    }
}