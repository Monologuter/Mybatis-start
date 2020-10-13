package com.educy.dao;

import com.educy.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 马小姐
 * @Date 2020-10-13 08:57
 * @Version 1.0
 * @Description:
 */
public interface UserMapper {
    List<User> queryUsers();

    User queryUserById(@Param("id") int id);
}
