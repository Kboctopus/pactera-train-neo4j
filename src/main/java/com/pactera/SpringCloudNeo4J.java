package com.pactera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class SpringCloudNeo4J {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudNeo4J.class, args);
	}
}
