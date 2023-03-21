import com.atguigu.mybatis.mapper.DynamicSQLMapper;

import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {

    @Test
    public void getEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByCondition = mapper.getEmpByCondition(new Emp(null, null, 23, "s", "s",null));
        System.out.println(empByCondition);
    }
    @Test
    public void getEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = mapper.getEmpByChoose(new Emp(null, null, null, null, null, null));
        System.out.println(emps);
    }
    @Test
    public void deleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8, 9});
        System.out.println(result);
    }
    @Test
    public void insertMoreByList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a",1,"男","123@321.com",null);
        Emp emp2 = new Emp(null,"b",1,"男","123@321.com",null);
        Emp emp3 = new Emp(null,"c",1,"男","123@321.com",null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int result = mapper.insertMoreByList(emps);
        System.out.println(result);
    }
}
