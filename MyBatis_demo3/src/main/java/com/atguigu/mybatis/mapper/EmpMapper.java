package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    List<Emp> getAllEmp();
    /**
     * 查询员工对应的部门
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    Emp getEmpAndDeptByStepOne(int i);

    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
