package com.why.start.sm.mapper;

import com.why.start.sm.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class StudentMapperImplTest {

    @Test
    public void test(){
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final StudentMapper bean = context.getBean(StudentMapper.class);
        final List<Student> students = bean.selsectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

}