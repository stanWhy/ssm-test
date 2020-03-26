package com.why.start.spring.service;

public class UserServiceImpl implements UserService {
    @Override
    public Integer add() {
        System.out.println("执行 add() 方法");
        return 1;
    }

    @Override
    public void del() {
        System.out.println("执行 del() 方法");
    }
}
