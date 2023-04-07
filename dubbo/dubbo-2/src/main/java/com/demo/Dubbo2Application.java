package com.demo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class Dubbo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Dubbo2Application.class, args);
    }

}
