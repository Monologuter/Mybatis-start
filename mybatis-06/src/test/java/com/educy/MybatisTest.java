package com.educy;

import com.educy.dao.StudentMapper;
import com.educy.dao.TeacherMapper;
import com.educy.entity.Student;
import com.educy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author 马小姐
 * @Date 2020-10-09 19:24
 * @Version 1.0
 * @Description:
 */


public class MybatisTest {
    public static void main(String[] args){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        com.educy.entity.Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }


    @Test
    public  void  getStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.geStudent();
        for (com.educy.entity.Student studentList:students){
            System.out.println(studentList);
        }

        sqlSession.close();
    }


    @Test
    public  void  getStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.geStudent2();
        for (com.educy.entity.Student studentList:students){
            System.out.println(studentList);
        }

        sqlSession.close();
    }




}
