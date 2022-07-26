package com.airline.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.airline.admin.entity.Airline;
import com.airline.admin.entity.Flight;
import com.airline.admin.entity.Seat;
import com.airline.admin.exception.AirlineNotFoundException;
import com.airline.admin.exception.FlightNotFoundException;
import com.airline.admin.model.SearchCriteria;
import com.airline.admin.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	
	@Override
	public Flight addFlight(Flight flight) {
		//need to ask why
		for(Seat s: flight.getSeats()) {
			s.setFlight(flight);
		}
		return flightRepository.save(flight);
	}

	@Override
	public List<Flight> searchFlight(SearchCriteria searchCriteria) throws FlightNotFoundException {
		
		String toPlace = searchCriteria.getToPlace();
		String fromPlace = searchCriteria.getFromPlace();
		String startTime = searchCriteria.getStartTime();
		String startDate = searchCriteria.getStartDate();
		
		Flight findFlight = new Flight();
		
		if(toPlace!=null && !toPlace.isEmpty())
			findFlight.setToPlace(toPlace);
		
		if(fromPlace!=null && !fromPlace.isEmpty())
			findFlight.setFromPlace(fromPlace);
		
		if(startTime!=null && !startTime.isEmpty())
			findFlight.setStartTime(startTime);
		
		if(startDate!=null && !startDate.isEmpty())
			findFlight.setStartDate(startDate);
		
		ExampleMatcher matcher = ExampleMatcher.matching();
		Example<Flight> example = Example.of(findFlight,matcher);
		
		List<Flight> flight = flightRepository.findAll(example);

		if(flight!=null && !flight.isEmpty())
			return flight;
		else
			throw new FlightNotFoundException("Flight not availble");
	}

	@Override
	public Flight editFlight(Integer id,Flight flight) throws FlightNotFoundException {
		
		if (flightRepository.existsById(id)) {

			Optional<Flight> foundFlight = flightRepository.findById(id);
			Flight updatedFlight = foundFlight.get();
			
			updatedFlight.setEndDate(flight.getEndDate());
			updatedFlight.setEndTime(flight.getEndTime());
			updatedFlight.setFlightNo(flight.getFlightNo());
			updatedFlight.setFromPlace(flight.getFromPlace());
			updatedFlight.setSeats(flight.getSeats());
			updatedFlight.setStartDate(flight.getStartDate());
			updatedFlight.setStartTime(flight.getStartTime());
			updatedFlight.setToPlace(flight.getToPlace());
			
			for(Seat s: updatedFlight.getSeats()) {
				s.setFlight(updatedFlight);
			}
			
			return flightRepository.save(updatedFlight);
		} else {
			throw new FlightNotFoundException("Flight with id: " + id + " not founnd");
		}
		
	}

	@Override
	public List<Flight> getFlights() {
		
		return flightRepository.findAll();
	}

	
}
