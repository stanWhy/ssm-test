package com.why.start.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;

    public User(String name){
        this.name = name;
    }

    public User(int age){
        this.age = age;
    }

    public void show (){
        System.out.println("name "+name);
        System.out.println("age " +age);
    }
}
