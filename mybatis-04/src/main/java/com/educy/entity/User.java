package com.educy.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author 马小姐
 * @Date 2020-09-28 14:50
 * @Version 1.0
 * @Description:
 */

@Data
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private  String sex;
    private String address;

    public User(String username, Date birthday, String sex, String address) {

        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public User(Integer id, String username, String sex, String address) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.address = address;
    }

    public User(Integer id) {
        this.id = id;
    }
}
