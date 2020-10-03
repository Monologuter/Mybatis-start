package com.educy.entity;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Author 马小姐
 * @Date 2020-09-30 09:18
 * @Version 1.0
 * @Description:
 */
@Data
public class Student {
    private Integer id;
    private  String sn;
    private  String username;
    private String password;
    private String sex;
    private String mobile;
    private String qq;

}
