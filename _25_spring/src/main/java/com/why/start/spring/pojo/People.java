package com.why.start.spring.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
//@Component
public class People {
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;

    public void test(){
        cat.shot();
        dog.shot();
    }
}
