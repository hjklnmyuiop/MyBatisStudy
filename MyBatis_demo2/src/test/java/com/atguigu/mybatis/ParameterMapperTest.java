package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ParameterMapperTest {
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
    }
    @Test
    public void testJDBC() throws Exception {
        String username= "admin";
        Class<?> aClass = Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        PreparedStatement preparedStatement = connection.prepareStatement("select  * from t_user where username=?");
        preparedStatement.setString(1,username);
    }
    @Test
    public void getUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("张五");
        System.out.println(user);
    }
    @Test
    public void checkLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("张五","123456");
        System.out.println(user);
    }
    @Test
    public void checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","张五");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user1 = new User(null, "张五", "123456", 2, "男", "");
        int i = mapper.insertUser(user1);
        System.out.println(i);
    }
    @Test
    public void checkLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("张五", "123456");
        System.out.println(user);
    }
}
