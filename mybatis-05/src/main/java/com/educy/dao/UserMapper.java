package com.educy.dao;

import com.educy.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @Author 马小姐
 * @Date 2020-09-28 14:52
 * @Version 1.0
 * @Description:
 */
public interface UserMapper {

     //查询全部用户
     @Select("select * from user")
     List<User>  getUserList();

     //根据用户id查询用户  方法存在多个参数的时候  参数前面必须加上@Param注解
     @Select("select * from user where id = #{id} and username=#{username}")
     User getUserById(@Param("id") int id , @Param("username") String username );

     //增加用户
     @Select("insert into user (username ,birthday, sex,address) value (#{username},#{birthday} ,#{sex} , #{address})")
     Integer addUser(User user);

     //删除用户
     @Delete("delete from user where id = #{id}")
     Integer deleteUser(int id);

     //更新用户
     @Update("update user set username=#{username} where id = #{id}")
     Integer updateUser(User user);
}
