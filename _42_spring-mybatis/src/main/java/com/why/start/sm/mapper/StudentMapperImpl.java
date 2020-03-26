package com.why.start.sm.mapper;

import com.why.start.sm.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class StudentMapperImpl extends SqlSessionDaoSupport implements StudentMapper {


    @Override
    public int insertStudent(Student student) {
        final SqlSession sqlSession = getSqlSession();
        final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        final int i = mapper.insertStudent(student);
        return i;
    }

    @Override
    public List<Student> selsectAll() {
        final SqlSession sqlSession = getSqlSession();
        final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        final List<Student> students = mapper.selsectAll();
        return students;
    }
}
