package com.educy.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author 马小姐
 * @Date 2020-10-03 21:40
 * @Version 1.0
 * @Description:
 */
@Data
public class tUser {
    private Integer id;
    private String name;
    private Date birthday;
    private  String sex;
    private String address;
    private String pwd;

    public tUser(Integer id, String name, Date birthday, String sex, String address, String pwd) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.pwd = pwd;
    }

    public tUser() {
    }
}
