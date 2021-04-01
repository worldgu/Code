package com.zero.lockdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableEurekaClient
@SpringBootApplication
@EnableAsync
public class LockdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LockdemoApplication.class, args);
	}

}
