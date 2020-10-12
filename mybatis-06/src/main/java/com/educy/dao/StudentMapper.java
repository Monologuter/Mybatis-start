package com.educy.dao;

import com.educy.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 马小姐
 * @Date 2020-10-09 19:16
 * @Version 1.0
 * @Description:
 */
public interface StudentMapper {


    List<Student> geStudent();

    List<Student> geStudent2();
}
