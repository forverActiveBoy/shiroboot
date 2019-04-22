package com.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*开启事物注解*/
@EnableTransactionManagement
/*告诉SpringBoot的dao接口位置*/
@MapperScan("com.alibaba.dao")
@SpringBootApplication
public class ShirobootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShirobootApplication.class, args);
	}

}
