package com.xiangmaikeji.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "com.xiangmaikeji.framework.mapper")
public class FrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameworkApplication.class, args);
	}
}
