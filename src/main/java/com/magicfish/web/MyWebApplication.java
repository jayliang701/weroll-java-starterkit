package com.magicfish.web;

import com.magicfish.weroll.Weroll;
import com.magicfish.weroll.WerollApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.magicfish.web.dao"})
@Weroll
@SpringBootApplication
public class MyWebApplication {

	public static void main(String[] args) {
        WerollApplication.run(MyWebApplication.class, args);
	}

}
