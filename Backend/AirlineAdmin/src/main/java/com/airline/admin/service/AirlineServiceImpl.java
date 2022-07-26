package com.airline.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.admin.entity.Airline;
import com.airline.admin.exception.AirlineNotFoundException;
import com.airline.admin.repository.AirlineRepository;

@Service
public class AirlineServiceImpl implements AirlineService {
	
	@Autowired
	AirlineRepository airlineRepository;

	@Override	
	public Airline addAirline(Airline airline) {

		return airlineRepository.save(airline);
	}

	@Override
	public Airline changeStatus(Airline airline) throws AirlineNotFoundException {
		
		int id = airline.getId();
		
		if (airlineRepository.existsById(id)) {

			Optional<Airline> foundAirline = airlineRepository.findById(id);
			Airline updatedAirline = foundAirline.get();
			if(airline.getName()!=null)
				updatedAirline.setName(airline.getName());
			updatedAirline.setStatus(airline.getStatus());
			return airlineRepository.save(updatedAirline);
			
		} else {
			throw new AirlineNotFoundException("Airline with id: " + id + " not founnd");
		}

	}

	@Override
	public List<Airline> getAirlines() {

		return airlineRepository.findAll();
	}

}
