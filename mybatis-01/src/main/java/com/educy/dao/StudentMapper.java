package com.educy.dao;

import com.educy.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 马小姐
 * @Date 2020-09-30 09:19
 * @Version 1.0
 * @Description:
 */
public interface StudentMapper {

    @Select("select * from s_student")
    List<Student> getAllStudent();


}
