package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.SQLMapper;
import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SQLMapperTest {
    @Test
    public void getUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> userByLike = mapper.getUserByLike("16");
        System.out.println(userByLike);
    }
    //测试类
    @Test
    public void deleteMore() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("'1','2','3','8'");
        System.out.println(result);
    }
    @Test
    public void getUserByTable() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> t_user = mapper.getUserByTable("t_user");
        System.out.println(t_user);
    }
    @Test
    public void insertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "ton", "123", 23, "男", "123@321.com");
        mapper.insertUser(user);
        System.out.println(user);
        //输出：user{id=10, username='ton', password='123', age=23, sex='男', email='123@321.com'}，自增主键存放到了user的id属性中
    }
}
