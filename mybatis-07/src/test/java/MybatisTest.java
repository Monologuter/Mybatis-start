import com.educy.dao.TeacherMapper;
import com.educy.entity.Teacher;
import com.educy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author 马小姐
 * @Date 2020-10-12 09:50
 * @Version 1.0
 * @Description:
 */
public class MybatisTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = mapper.getTeacher();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }


    @Test
    public void TeacherStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher2 = mapper.getTeacher2(1);
        System.out.println(teacher2);
        sqlSession.close();
    }


    @Test
    public void TeacherStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher3 = mapper.getTeacher3(1);
        System.out.println(teacher3);
        sqlSession.close();
    }
}
