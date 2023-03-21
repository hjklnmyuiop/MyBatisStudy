package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface ParameterMapper {
    /**
     *
     * @param username
     * @return
     */
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
    User checkLogin( String username,String password);
    User getUserByUsername(String username);
    /**
     *
     */
    List<User> getAllUser();

    User checkLoginByMap(HashMap<String, Object> map);
    int insertUser(User user);

}
