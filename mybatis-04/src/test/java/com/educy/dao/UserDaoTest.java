package com.educy.dao;

import com.educy.entity.User;
import com.educy.entity.tUser;
import com.educy.util.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


/**
 * @Author 马小姐
 * @Date 2020-09-28 15:10
 * @Version 1.0
 * @Description:
 */

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);


    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.getUserById(41);
//        System.out.println(user);

//        sqlSession.close();

        tUserMapper mapper1  = sqlSession.getMapper(tUserMapper.class);
        tUser user1 = mapper1.getUserById(1);
        System.out.println(user1);
        sqlSession.close();
    }


    @Test
    public void testLog4j(){

        logger.info("info:进入了log4j");
        logger.debug("debug:进入了debug");
        logger.error("error:");

    }


    //实现分页查询
    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<String, Integer>();
        stringIntegerHashMap.put("startIndex",0);
        stringIntegerHashMap.put("endIndex",7);
        List<User> userByLimit = mapper.getUserByLimit(stringIntegerHashMap);
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    //是以RowBounds实现分页查询
    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(2,10);

        List<User> userList = sqlSession.selectList("com.educy.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

}
