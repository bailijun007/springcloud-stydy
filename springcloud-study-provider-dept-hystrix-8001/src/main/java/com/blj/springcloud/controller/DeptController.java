package com.blj.springcloud.controller;

import com.blj.springcloud.entities.Dept;
import com.blj.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    //-旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public Dept get(@PathVariable("deptno") Long deptno){
        Dept dept = deptService.findById(deptno);
        if (dept == null) {
            throw new RuntimeException("该ID"+deptno+"没有对应信息！");
        }
        return dept;
    }

    public Dept processHystrixGet(@PathVariable("deptno")Long deptno){
       return new Dept().setDeptno(deptno).setDname("该deptNo没有对应的信息").setDbSource("没有这个数据库");
    }

    @GetMapping(value = "/list")
    public List<Dept> list(){
        return deptService.findAll();
    }


}
