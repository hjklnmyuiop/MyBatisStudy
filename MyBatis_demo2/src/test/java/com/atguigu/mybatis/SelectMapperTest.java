package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SelectMapperTest {
    @Test
    public void getUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List userById = mapper.getUserById(16);
        for (Object user : userById) {
            System.out.println(user);
        }
    }
    @Test
    public void getCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        int count = mapper.getCount();
        System.out.println(count);
    }
    @Test
    public void getUserByIdTpMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdTpMap = mapper.getUserByIdTpMap(16);
        System.out.println(userByIdTpMap);
    }
    @Test
    public void getAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        allUserToMap.get(16);
        System.out.println(allUserToMap.get(16));
    }
}
