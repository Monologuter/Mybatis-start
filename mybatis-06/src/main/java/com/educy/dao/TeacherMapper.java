package com.educy.dao;

import com.educy.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author 马小姐
 * @Date 2020-10-09 19:16
 * @Version 1.0
 * @Description:
 */
public interface TeacherMapper {

    Teacher getTeacher(@Param("tid") int id);

}
