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

}
