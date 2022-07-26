package com.airline.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airline.admin.entity.Flight;
import com.airline.admin.exception.FlightNotFoundException;
import com.airline.admin.model.SearchCriteria;

@Service
public interface FlightService {

	public Flight addFlight(Flight flight);
	
	public List<Flight> searchFlight(SearchCriteria searchCriteria) throws FlightNotFoundException;

	public Flight editFlight(Integer id,Flight flight) throws FlightNotFoundException;

	public List<Flight> getFlights();
}
