package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

/**
 * @Author: dev_guo
 * @Date: 2023/3/13 18:07
 */
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();
    void updateUser();
    void deleteUser();
    User getUserById();
    List<User> getUserList();
}
