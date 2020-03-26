package com.why.start.spring.service;

public class UserServiceImpl1 implements UserService {
    @Override
    public int add() {
        System.out.println("原始 add() 方法");
        return 1;
    }

    @Override
    public void del() {
        System.out.println("原始 del() 方法");
    }
}
