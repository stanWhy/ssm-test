package com.why.start.spring.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {

    private String name;
    /*@Autowired*/
    private Dog dog;
}
