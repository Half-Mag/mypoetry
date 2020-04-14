package com.crisleee.mypoetry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
@EnableDubbo
@SpringBootApplication
public class BootMypoertyUser1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMypoertyUser1Application.class, args);
	}

}
