package com.why.start.sm.mapper;

import com.why.start.sm.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentMapperTest {

    @Test
    public void test() throws IOException {
        final SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        final int aaa = mapper.insertStudent(new Student(7, "AAA", 1));
        if (aaa == 1){
            System.out.println("插入成功");
        }
        final List<Student> students = mapper.selsectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

}