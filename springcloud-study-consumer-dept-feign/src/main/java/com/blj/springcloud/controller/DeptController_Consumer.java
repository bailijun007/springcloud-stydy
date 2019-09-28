package com.blj.springcloud.controller;

import com.blj.springcloud.entities.Dept;
import com.blj.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "consumer")
public class DeptController_Consumer {
    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/dept/add")
    public boolean add( Dept dept){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.add(dept);
    }
    @RequestMapping("/dept/get/{deptno}")
    public Dept get(Long deptno){
        //三个参数：url,requestMap ResponseBean.class
        return deptClientService.get(deptno);
    }
    @RequestMapping("/dept/list")
    public List list(){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.list();
    }

}
