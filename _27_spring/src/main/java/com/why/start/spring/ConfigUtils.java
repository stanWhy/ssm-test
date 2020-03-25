package com.why.start.spring;

import com.why.start.spring.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigUtils {

    @Bean
    public User getUser(){
        return new User();
    }
}
