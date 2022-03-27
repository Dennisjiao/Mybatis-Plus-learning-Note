package com.atauigu.demomybatistest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atauigu.demomybatistest.mapper")
public class DemomybatistestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemomybatistestApplication.class, args);
    }

}
