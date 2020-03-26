package com.why.start.spring.service;

public class UserServiceImpl2 implements UserService {
    @Override
    public int add() {
        System.out.println("自定义 add() 方法");
        return 1;
    }

    @Override
    public void del() {
        System.out.println("自定义 del() 方法");
    }
}
