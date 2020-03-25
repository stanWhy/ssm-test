package com.why.start.spring.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Proxy implements Rent{

    @Autowired
    private Host host;
    //带看房
    public void look(){
        System.out.println("看房");
    }

    //调用房东租房
    @Override
    public void rent() {
        host.rent();
    }

    //收钱
    public void money(){
        System.out.println("收钱");
    }
}
