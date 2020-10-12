package com.educy.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author 马小姐
 * @Date 2020-10-12 11:10
 * @Version 1.0
 * @Description:
 */
@Data
public class Blog {
    private  String id;
    private  String title;
    private  String author;
    private  Date  createTime;
    private  int views;
}
