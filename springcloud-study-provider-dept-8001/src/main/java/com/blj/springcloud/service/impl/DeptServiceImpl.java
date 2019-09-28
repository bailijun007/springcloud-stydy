package com.blj.springcloud.service.impl;

import com.blj.springcloud.dao.DeptDao;
import com.blj.springcloud.entities.Dept;
import com.blj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept findById(Long deptno) {
        return deptDao.findById(deptno);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
