import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MBGTest {
    @Test
    public void  testMBG(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
//            List<Emp> list = mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));
//            EmpExample empExample = new EmpExample();
            //查询条件查询数据
//            empExample.createCriteria()
//                    .andEmpNameEqualTo("张三")
//                    .andAgeEqualTo(20);
//            empExample.or().andDidIsNotNull();
//            List<Emp> list = mapper.selectByExample(empExample);
//            list.forEach(emp -> System.out.println(emp));
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null,"qq",null));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
