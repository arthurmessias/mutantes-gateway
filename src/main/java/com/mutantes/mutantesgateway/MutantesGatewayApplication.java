package com.mutantes.mutantesgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MutantesGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutantesGatewayApplication.class, args);
	}

}
