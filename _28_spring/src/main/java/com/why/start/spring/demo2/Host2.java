package com.why.start.spring.demo2;

import org.springframework.stereotype.Component;

@Component
public class Host2 implements Rent2{
    @Override
    public void rent() {
        System.out.println("B房东想要租房");
    }
}
