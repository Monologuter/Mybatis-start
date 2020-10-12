import com.educy.dao.BlogMapper;
import com.educy.entity.Blog;
import com.educy.util.IDutils;
import com.educy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @Author 马小姐
 * @Date 2020-10-12 11:45
 * @Version 1.0
 * @Description:
 */
public class MybatisTest {
    public static void main(String[] args) {
        java.util.Date utilDate=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());


        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);


        Blog blog  = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mysql");
        blog.setAuthor("陈亚");
        blog.setCreateTime(sqlDate);
        blog.setViews(99);

        mapper.addBlog(blog);

        sqlSession.close();
    }


    @Test
    public  void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap ();

        hashMap.put("title","spring");
        hashMap.put("author","陈亚");

        List<Blog> blogs = mapper.queryBlogIF(hashMap);
        for (Blog blog : blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public  void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap ();
//        hashMap.put("title","springboot9999");
//        hashMap.put("author","狂神说");
        hashMap.put("views",999);
        List<Blog> blogs = mapper.queryBlogChoose(hashMap);
        for (Blog blog : blogs){
            System.out.println(blog);
        }
    }


    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap ();
        hashMap.put("title","springboot888");
        hashMap.put("author","狂神");
        hashMap.put("id","036f0fc00c414242ad7c01c92c114250");
        mapper.updateBlog(hashMap);

    }


    @Test
    public void quBlogsForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        hashMap.put("ids",ids);

        List<Blog> blogs = mapper.quBlogsForeach(hashMap);
        for (Blog blog : blogs){
            System.out.println(blog);
        }
    }

}
