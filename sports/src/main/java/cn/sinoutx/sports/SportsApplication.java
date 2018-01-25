package cn.sinoutx.sports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement//开启事务注解
@SpringBootApplication
public class SportsApplication {
	  @Bean
	    public Object testBean(PlatformTransactionManager platformTransactionManager){
	        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
	        return new Object();
	    }

	public static void main(String[] args) {
		SpringApplication.run(SportsApplication.class, args);
	}
}

