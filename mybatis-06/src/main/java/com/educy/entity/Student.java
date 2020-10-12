package com.educy.entity;

import lombok.Data;

/**
 * @Author 马小姐
 * @Date 2020-10-09 19:11
 * @Version 1.0
 * @Description:
 */
@Data
public class Student {
    private int id;
    private String name;

    //学生需要关联一个老师
    private Teacher teacher;
}
