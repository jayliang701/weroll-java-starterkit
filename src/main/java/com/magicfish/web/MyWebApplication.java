package com.magicfish.web;

import com.magicfish.weroll.Weroll;
import com.magicfish.weroll.WerollApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({
    "com.magicfish.web.domain.service",
    "com.magicfish.web.domain.repository"
})
@Weroll(apiScan = {
	"com.magicfish.web.api"
})
@SpringBootApplication
public class MyWebApplication {

	public static void main(String[] args) throws Exception {
        WerollApplication.run(MyWebApplication.class, args);
	}

}
