package com.why.start.spring.service;

public class UserServiceImpl3 implements UserService {
    @Override
    public int add() {
        System.out.println("注解 add() 方法");
        return 1;
    }

    @Override
    public void del() {
        System.out.println("注解 del() 方法");
    }
}
