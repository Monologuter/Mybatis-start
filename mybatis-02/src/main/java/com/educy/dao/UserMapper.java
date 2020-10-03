package com.educy.dao;

import com.educy.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Author 马小姐
 * @Date 2020-09-28 14:52
 * @Version 1.0
 * @Description:
 */
public interface UserMapper {
//    @Select("select * from user")
    List<User> getUserList();


//    @Select("select * from user where id= 41")
     User getUserById(int i);


    //增加用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(Integer id);


}
