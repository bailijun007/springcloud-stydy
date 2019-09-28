package com.blj.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)//chain 若为true，则setter方法返回当前对象
@SuppressWarnings("serial")//("serial") 是序列化警告，当实现了序列化接口的类上缺少serialVersionUID属性的定义时，会出现黄色警告。可以使用@SuppressWarnings将警告关闭
public class Dept implements Serializable {

    private Long deptno;//主键
    private String dname;//部门名称
    private String dbSource;//来自哪个数据库，因为微服务可以一个微服务对于一个数据库，同一个信息可以被存储到不同的数据库

}
