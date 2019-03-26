package com.magicfish.web;

import com.magicfish.weroll.Weroll;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.magicfish.web.dao"})
@Weroll
@SpringBootApplication
public class WerollJavaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WerollJavaWebApplication.class, args);
	}

}
