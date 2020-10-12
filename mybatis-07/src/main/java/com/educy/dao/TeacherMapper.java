package com.educy.dao;

import com.educy.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 马小姐
 * @Date 2020-10-09 19:16
 * @Version 1.0
 * @Description:
 */
public interface TeacherMapper {
    //获取老师
    List<Teacher> getTeacher();

    //获取老师及其他的学生
    Teacher getTeacher2(@Param("tid") int id);

    Teacher getTeacher3(@Param("tid") int id);
}
