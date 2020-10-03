package com.educy.dao;

import com.educy.entity.User;

/**
 * @Author 马小姐
 * @Date 2020-09-28 14:52
 * @Version 1.0
 * @Description:
 */
public interface UserMapper {


//    @Select("select * from user where id= 41")
     User getUserById(int i);

}
