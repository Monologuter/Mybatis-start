package com.educy.dao;

import com.educy.entity.tUser;
import com.educy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;



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

}
