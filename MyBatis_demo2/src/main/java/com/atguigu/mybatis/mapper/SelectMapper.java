package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    List getUserById(@Param("id") Integer id);
    /**
     * 查询用户的总记录数
     * @return
     * 在MyBatis中，对于Java中常用的类型都设置了类型别名
     * 例如：java.lang.Integer-->int|integer
     * 例如：int-->_int|_integer
     * 例如：Map-->map,List-->list
     */
    int getCount();
    /**
     * 根据用户id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdTpMap(@Param("id") Integer id);
    @MapKey("id")
    Map<String, Object> getAllUserToMap();
}
