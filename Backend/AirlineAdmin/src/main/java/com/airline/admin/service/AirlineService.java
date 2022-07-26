package com.airline.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airline.admin.entity.Airline;
import com.airline.admin.exception.AirlineNotFoundException;

@Service
public interface AirlineService {

	public Airline addAirline(Airline airline);

	public Airline changeStatus(Airline airline) throws AirlineNotFoundException;

	public List<Airline> getAirlines();
}
