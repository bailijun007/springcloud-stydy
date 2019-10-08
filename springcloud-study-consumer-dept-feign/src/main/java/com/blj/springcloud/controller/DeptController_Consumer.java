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

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.add(dept);
    }
   // @GetMapping(value = "/dept/get/{deptno}",produces = "application/json")
    @RequestMapping(value = "/dept/get/{deptno}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("deptno") Long deptno){
        return deptClientService.get(deptno);
    }
    @GetMapping(value = "/dept/list")
    public List list(){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.list();
    }

}
