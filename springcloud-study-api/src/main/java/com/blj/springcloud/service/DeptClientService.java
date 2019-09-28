package com.blj.springcloud.service;

import com.blj.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "STUDY-SPRINGCLOUD-DEPT")
public interface DeptClientService {

    @RequestMapping(value = "/dept/add",method = RequestMethod.GET)
    public boolean add(Dept dept);

    @RequestMapping(value = "/dept/get/{deptno}",method = RequestMethod.GET)
    public Dept get(Long deptno);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List list();


}
