package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloud01EurekaClientProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloud01EurekaClientProviderApplication.class, args);
	}

}
