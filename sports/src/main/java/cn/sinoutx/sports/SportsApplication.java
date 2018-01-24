package cn.sinoutx.sports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement//开启事务注解
@SpringBootApplication
public class SportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsApplication.class, args);
	}
}

