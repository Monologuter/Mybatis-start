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
    public void testUserDaoTest() throws IOException {

        //获取SqlSession对象
        SqlSession sqlSession = null;

        try {
            sqlSession=MybatisUtils.getSqlSession();

            //执行sql  方式一
//        UserMapper dao = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = dao.getUserList();
//        for (User user : userList) {
//            System.out.println(user);
//        }


            //方式二  不推荐使用
            List<User> userList = sqlSession.selectList("com.educy.dao.UserMapper.getUserList");
            for (User user : userList) {
                System.out.println(user);
            }


            StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentDao.getAllStudent();
            for (Student student : studentList) {
                System.out.println(student);
            }


        } catch (Exception e) {

        } finally {
            //关闭sqlSession
            sqlSession.close();
        }




//        //1、读取配置文件
//        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//
//
//        //2、创建一个SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory  = builder.build(in);
//
//        //3、使用工厂生产一个sqlSession对象
//        SqlSession session = factory.openSession();
//        //4、使用SqlSession创建Dao接口的代理对象
//        UserDao dao = session.getMapper(UserDao.class);
//
//        List<User> userList = dao.getUserList();
//        for (User user : userList) {
//            System.out.println(user);
//        }
//        //关闭sqlSession
//        session.close();
//


    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(41);
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
    public void addUser2(){
        java.util.Date utilDate=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String , Object> map = new HashMap<String, Object>();
        map.put("username","李四");
//        map.put("birthday" , sqlDate);
        map.put("sex" ,"女");
//        map.put("address" ,"上海市");
        mapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public  void updateUser(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(53,"陈亚","女" ,"常州市"));
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

    @Test
    public  void updateUser2(){
        java.util.Date utilDate=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String , Object> map = new HashMap<String, Object>();
        map.put("id" , 41);
        map.put("username","陈亚777");
        map.put("birthday",sqlDate);
        map.put("birthday",sqlDate);
        map.put("sex" ,"男");
        map.put("address" ,"上海");
        mapper.updateUser2(map);
        sqlSession.commit();
        sqlSession.close();

    }


    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<User> userList = mapper.getUserLike("%李%");
            for (User user : userList) {
                System.out.println(user);
        }
            sqlSession.close();;
    }
}
