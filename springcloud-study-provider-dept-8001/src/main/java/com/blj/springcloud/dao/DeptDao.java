package com.blj.springcloud.dao;

import com.blj.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface DeptDao {

    //增加部门
    public boolean addDept(@Param("dept") Dept dept);

    //通过id查询部门信息
    public Dept findById(@Param("deptno") Long deptno);

    //查询所有部门信息
    public List<Dept> findAll();

}
