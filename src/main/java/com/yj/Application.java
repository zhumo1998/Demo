package com.yj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yj.dao")//扫描dao包
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
