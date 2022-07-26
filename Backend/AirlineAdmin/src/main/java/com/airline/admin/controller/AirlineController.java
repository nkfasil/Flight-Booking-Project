package com.airline.admin.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.admin.entity.Airline;
import com.airline.admin.exception.AirlineNotFoundException;
import com.airline.admin.service.AirlineService;
import com.airline.admin.service.KafkaConsumerListener;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/flight/airline")
public class AirlineController {
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private KafkaConsumerListener listener;
	
	private static final String TOPIC = "fasil1";

	
	@Autowired
	AirlineService airlineService;
	
	@PostMapping("/register")
	public ResponseEntity<Airline> registerAirline(@RequestBody Airline airline) {
		return new ResponseEntity<Airline>(airlineService.addAirline(airline),HttpStatus.OK);
	}
	
	@PutMapping("/editAirline")
	public ResponseEntity<Airline> editAirline(@RequestBody Airline airline) throws AirlineNotFoundException {
		
		ResponseEntity<Airline> responseEntity = new ResponseEntity<Airline>(airlineService.changeStatus(airline),HttpStatus.OK);
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			
			String name = responseEntity.getBody().getName();
			String status = responseEntity.getBody().getStatus();
			
			kafkaTemplate.send(TOPIC, "Airline: "+name+" status changed to "+status);

	        System.out.println("Published successfully: "+LocalDateTime.now());
		}
		return responseEntity;
	}
	
	@GetMapping("/consumer")
	public List<String> consume() {
		return listener.changes();
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String>("Hello homies", HttpStatus.OK);
	}
	
	@GetMapping("/airlines")
	public List<Airline> getAirlines()  {
		return airlineService.getAirlines();
	}
	
	

}
