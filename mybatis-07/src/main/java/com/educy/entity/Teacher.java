package com.educy.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author 马小姐
 * @Date 2020-10-09 19:14
 * @Version 1.0
 * @Description:
 */
@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student> students;
}
