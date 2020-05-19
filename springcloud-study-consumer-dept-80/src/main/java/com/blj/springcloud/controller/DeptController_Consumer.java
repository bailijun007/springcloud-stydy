package com.blj.springcloud.controller;

import com.blj.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sun.misc.Request;

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
         String url = REST_URL_PREFFIX + "/dept/add";
        return  restTemplate.postForObject(url, dept,Boolean.class);
    }

   // @GetMapping(value ="/dept/get/{deptno}")
   @RequestMapping(value = "/dept/get/{deptno}",method = RequestMethod.GET)
    public Dept get(@PathVariable("deptno") Long deptno){
        String url = REST_URL_PREFFIX + "/dept/get/" + deptno;
       return  restTemplate.getForObject(url,Dept.class);
    }

    @GetMapping(value ="/dept/list")
    public List<Dept> list(){
         String url = REST_URL_PREFFIX + "/dept/list";
        return  restTemplate.getForObject(url,List.class);
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
         String url = REST_URL_PREFFIX + "/dept/discovery";
        return  restTemplate.getForObject(
                url,
                Object.class);
    }


}
