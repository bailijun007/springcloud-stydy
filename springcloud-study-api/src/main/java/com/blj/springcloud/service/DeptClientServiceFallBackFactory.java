package com.blj.springcloud.service;

import com.blj.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
//@Component 不要忘记添加
//主业务与熔断方法解耦
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }


            public Dept get(Long deptno) {
                 return new Dept()
                         .setDeptno(deptno)
                        .setDname("该deptno没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
                        .setDbSource("没有这个数据库");
                  }

            @Override
            public List     list() {
                return null;
            }
        };
    }
}
