package com.chenkai.exhibition.dict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Kai Chen
 * @create 2021-05-12-0:21
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.chenkai")
public class ServiceDictApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDictApplication.class, args);
    }

}
