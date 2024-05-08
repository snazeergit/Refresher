package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloud02EurekaClientMs2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloud02EurekaClientMs2Application.class, args);
	}

}
