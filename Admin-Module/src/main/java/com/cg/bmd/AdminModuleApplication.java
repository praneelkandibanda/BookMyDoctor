package com.cg.bmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // It is equivalent to using @Configuration, @EnableAutoConfiguration
                        // and @ComponentScan
public class AdminModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminModuleApplication.class, args);  
	}

}
