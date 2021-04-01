package com.zero.apidriver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@EnableAsync
public class ApiDriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDriverApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}


}
