package com.airline.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AirlineBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineBookingApplication.class, args);
	}

}
