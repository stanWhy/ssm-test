package com.why.start.spring.demo1;

import org.springframework.stereotype.Component;

@Component
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("A房东有房出租");
    }
}
