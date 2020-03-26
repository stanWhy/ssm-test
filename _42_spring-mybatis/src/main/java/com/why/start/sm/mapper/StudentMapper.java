package com.why.start.sm.mapper;

import com.why.start.sm.pojo.Student;

import java.util.List;

public interface StudentMapper {

    int insertStudent(Student student);

    List<Student> selsectAll();
}
