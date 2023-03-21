import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CacheMapperTest {
    @Test
    public void getEmpById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empById = mapper.getEmpById(3);
        System.out.println(empById);
        mapper.insertEmp(new Emp(null, "GUOQINGAN", 23, "s", "s",null));
        Emp empById2 = mapper.getEmpById(3);
        System.out.println(empById);
//        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
//        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
//        Emp empById2 = mapper2.getEmpById(3);
//        System.out.println(empById2);
    }
    @Test
    public void getTwoCache(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession(true);
            CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            Emp empById = mapper.getEmpById(1);
            System.out.println(empById);
            sqlSession.commit();
            SqlSession sqlSession2 = build.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp empById2 = mapper2.getEmpById(1);
            System.out.println(empById2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
