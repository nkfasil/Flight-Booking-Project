package com.airline.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.admin.entity.Flight;
import com.airline.admin.exception.FlightNotFoundException;
import com.airline.admin.model.SearchCriteria;
import com.airline.admin.service.FlightService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@PostMapping("/airline/inventory/add")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
		return new ResponseEntity<Flight>(flightService.addFlight(flight), HttpStatus.CREATED);
	}
	
	@PostMapping("/search")
	public List<Flight> searchFlight(@RequestBody SearchCriteria searchCriteria) throws FlightNotFoundException{
		return  flightService.searchFlight(searchCriteria);
	}
	
	@PutMapping("/airline/inventory/edit/{id}")
	public ResponseEntity<Flight> editFlight(@PathVariable("id") Integer id, @RequestBody Flight flight) throws FlightNotFoundException{
		return new ResponseEntity<Flight>(flightService.editFlight(id,flight), HttpStatus.OK);
	}
	
	@GetMapping("/flights")
	public List<Flight> getFlights(){
		return  flightService.getFlights();
	}

}
