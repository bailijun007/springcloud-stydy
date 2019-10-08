package com.blj.springcloud.controller;

import com.blj.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "consumer")
public class DeptController_Consumer {

    //public static final  String REST_URL_PREFFIX="http://localhost:8001";
    public static final  String REST_URL_PREFFIX="http://STUDY-SPRINGCLOUD-DEPT";

    //使用restTemplate访问restful接口非常简单粗暴
    //(url,requestMap,responseBean.class)这三个参数分别代表
    //REST请求地址，请求参数，HTTP响应被转换的对象类型
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept){
        return  restTemplate.postForObject(REST_URL_PREFFIX+"/dept/add",dept,Boolean.class);
    }

   // @GetMapping(value ="/dept/get/{deptno}")
   @RequestMapping(value = "/dept/get/{deptno}",method = RequestMethod.GET)
    public Dept get(@PathVariable("deptno") Long deptno){
        return  restTemplate.getForObject(REST_URL_PREFFIX+"/dept/get/"+deptno,Dept.class);
    }

    @GetMapping(value ="/dept/list")
    public List<Dept> list(){
        return  restTemplate.getForObject(REST_URL_PREFFIX+"/dept/list",List.class);
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        return  restTemplate.getForObject(
                REST_URL_PREFFIX+"/dept/discovery",
                Object.class);
    }


}
