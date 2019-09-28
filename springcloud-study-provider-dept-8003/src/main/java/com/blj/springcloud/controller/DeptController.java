package com.blj.springcloud.controller;

import com.blj.springcloud.entities.Dept;
import com.blj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DiscoveryClient discoveryClient;


    @Autowired
    private DeptService deptService;

   // @RequestMapping(value = "/add",produces = "application/json",method = RequestMethod.POST)
   @PostMapping("add")
    public Boolean addDept(@RequestBody  Dept dept){
        System.out.println("dept = " + dept);
       return deptService.addDept(dept);
    }

    @GetMapping(value = "/get/{deptno}")
    public Dept findById(@PathVariable("deptno") Long deptno){
        return deptService.findById(deptno);
    }

    @GetMapping(value = "/list")
    public List<Dept> findAll(){
        return deptService.findAll();
    }

    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("STUDY-SPRINGCLOUD-DEPT");

        for (ServiceInstance element :instances){
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;

    }


}
