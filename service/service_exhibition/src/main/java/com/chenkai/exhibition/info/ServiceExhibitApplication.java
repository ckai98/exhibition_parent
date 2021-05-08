package com.chenkai.exhibition.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Kai Chen
 * @create 2021-05-09-2:02
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.chenkai")
public class ServiceExhibitApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceExhibitApplication.class, args);
    }

}
