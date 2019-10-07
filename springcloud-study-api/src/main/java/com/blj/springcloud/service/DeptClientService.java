package com.blj.springcloud.service;

import com.blj.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(value = "STUDY-SPRINGCLOUD-DEPT")
@FeignClient(value = "STUDY-SPRINGCLOUD-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);

   // @RequestMapping(value = "/dept/get/{deptno}",method = RequestMethod.GET,produces = "application/json")
    @GetMapping(value = "/dept/get/{deptno}",produces = "application/json")
    public Dept get(@PathVariable("deptno") Long deptno);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List list();


}
