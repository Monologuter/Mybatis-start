package com.educy.dao;

import com.educy.entity.Student;
import com.educy.entity.User;
import com.educy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 马小姐
 * @Date 2020-09-28 15:10
 * @Version 1.0
 * @Description:
 */

public class UserDaoTest {
    @Test
   public void getUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(43);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser(){
        java.util.Date utilDate=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User( "陈亚", sqlDate, "男", "江苏省"));
        if (res > 0) {
            System.out.println("插入成功");
        }

        //提交事务   查询不需要提交事务 但是增删改必须要提交事务
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public  void updateUser(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(102,"乔碧萝","女" ,"常州市"));
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(53);
        sqlSession.commit();
        sqlSession.close();

    }

}
