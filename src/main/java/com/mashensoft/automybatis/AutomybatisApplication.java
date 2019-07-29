package com.mashensoft.automybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.mashensoft.automybatis.mapper")
@SpringBootApplication
public class AutomybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomybatisApplication.class, args);
	}

}
