package com.blj.springcloud.service;

import com.blj.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {
    //增加部门
    public boolean addDept(Dept dept);

    //通过id查询部门信息
    public Dept findById(Long deptno);

    //查询所有部门信息
    public List<Dept> findAll();
}
