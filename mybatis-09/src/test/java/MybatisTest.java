import com.educy.dao.UserMapper;
import com.educy.entity.User;
import com.educy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author 马小姐
 * @Date 2020-10-13 09:10
 * @Version 1.0
 * @Description:
 */
public class MybatisTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public void queryUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(41);
        System.out.println(user);
        sqlSession.clearCache();
        User user1 = mapper.queryUserById(41);
        System.out.println(user1);
        sqlSession.close();
    }
}
