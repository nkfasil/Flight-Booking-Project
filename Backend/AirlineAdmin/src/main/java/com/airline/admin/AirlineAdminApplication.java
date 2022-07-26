package com.airline.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AirlineAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineAdminApplication.class, args);
	}

}
