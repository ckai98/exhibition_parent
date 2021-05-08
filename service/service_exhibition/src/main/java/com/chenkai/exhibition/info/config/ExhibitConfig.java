package com.chenkai.exhibition.info.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kai Chen
 * @create 2021-05-09-3:06
 */

@Configuration
@MapperScan("com.chenkai.exhibition.info.mapper")
public class ExhibitConfig {
}
