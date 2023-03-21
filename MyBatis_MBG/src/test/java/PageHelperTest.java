import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {
    @Test
    public void testPageHelper(){
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            PageHelper.startPage(3, 3);
            List<Emp> list = mapper.selectByExample(null);
            PageInfo<Emp> page = new PageInfo<>(list,3);

            page.getList().forEach(w-> System.out.println(w));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
