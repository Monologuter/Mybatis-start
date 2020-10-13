package com.educy.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author 马小姐
 * @Date 2020-10-12 17:49
 * @Version 1.0
 * @Description:
 */
@Data
public class User {
    private int id;
    private String username;
    private Date birthday;
    private char sex;
    private String adddres;

}
