package com.why.start.spring.pojo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void test(){
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final Student student = context.getBean("student", Student.class);
        final Address address = student.getAddress();
        System.out.println(address.getAddress());
        System.out.println(student.getName());
        System.out.println(student.getBooks());
        final Map<String, String> card = student.getCard();
        for(String key : card.keySet()){
            System.out.println(key+card.get(key));
        }
        final Set<String> games = student.getGames();
        for (String game : games) {
            System.out.println(game);
        }
        for (String hobby : student.getHobbys()) {
            System.out.println(hobby);
        }
        final Properties info = student.getInfo();
        System.out.println(info.get("url"));
    }

}