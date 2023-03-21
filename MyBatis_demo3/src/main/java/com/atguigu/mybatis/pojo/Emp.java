package com.atguigu.mybatis.pojo;

import java.io.Serializable;

public class Emp implements Serializable {
    private Integer eid;
    private String empName;
    private Integer age;
    private String sex;
    private String email;

    private Dept dept;
    public Emp() {
    }
    public Emp(Integer eid, String empName, Integer age, String sex, String email,Dept dept) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.dept = dept;
    }

    public Integer getEid() {
        return eid;
    }

    public String getEmpName() {
        return empName;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                '}';
    }
}
