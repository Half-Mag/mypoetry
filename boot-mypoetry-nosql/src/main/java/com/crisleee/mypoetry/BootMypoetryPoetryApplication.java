package com.crisleee.mypoetry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableDubbo
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BootMypoetryPoetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMypoetryPoetryApplication.class, args);
	}

}
