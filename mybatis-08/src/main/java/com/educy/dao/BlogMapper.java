package com.educy.dao;

import com.educy.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author 马小姐
 * @Date 2020-10-12 11:15
 * @Version 1.0
 * @Description:
 */
public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);

    //查询博客 if
    List<Blog> queryBlogIF(Map map);

    //查询博客 choose
    List<Blog> queryBlogChoose(Map map);


    //更新博客
    int updateBlog(Map map);


    //查询第 1 2 3 号博客的详细信息  注意  先去数据库中将id改为1234的形式  原来的随机数测试比较麻烦
    List<Blog> quBlogsForeach(Map map);


}
