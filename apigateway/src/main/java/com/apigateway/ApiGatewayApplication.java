package com.apigateway;

import com.apigateway.config.RedisConnectionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebFluxSecurity
public class ApiGatewayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}


	@Autowired
	private RedisConnectionValidator redisConnectionValidator;
	@Override
	public void run(String... args) throws Exception {
		if(redisConnectionValidator.validateConnection()){
			System.out.println("----------------------------------------------->Connected to Redis");
		}else{
			System.out.println("----------------------------------------------->Failed to connect to Redis");
		}
	}
}
