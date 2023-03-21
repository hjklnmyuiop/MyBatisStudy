package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;


public interface CacheMapper {
    Emp getEmpById(Integer eid);
    void  insertEmp(Emp emp);
}
