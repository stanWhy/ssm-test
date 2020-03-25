package com.why.start.spring.demo3;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add() 方法");
    }

    @Override
    public void del() {
        System.out.println("del() 方法");
    }
}
