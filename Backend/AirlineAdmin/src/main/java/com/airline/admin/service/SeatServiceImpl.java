package com.airline.admin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.admin.entity.Seat;
import com.airline.admin.exception.SeatNotFoundException;
import com.airline.admin.repository.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	SeatRepository seatRepository;
	
	@Override
	public Seat updateSeatStatus(Integer seatNo, String status, Integer flightId) throws SeatNotFoundException {
		
		Optional<Seat> seatOp =  seatRepository.findAllBySeatNoAndFlightId(seatNo, flightId);
		//ensures seat is present or not
		//should also ensure seat must not be booked prior
		if(seatOp.isPresent()) {
			Seat seat = seatOp.get();
			if(seat.getStatus().equals("booked")) {
				throw new SeatNotFoundException("Seat no: "+seatNo +" is already booked");
			}
			seat.setStatus("booked");
			return seatRepository.save(seat);
		} else {
			// throw exception
			throw new SeatNotFoundException("Seat no: "+seatNo +" not available to book");
		}
	
	}

	@Override
	public Seat cancelSeatStatus(Integer seatNo, String status, Integer flightId) throws SeatNotFoundException {
		
		Optional<Seat> seatOp =  seatRepository.findAllBySeatNoAndFlightId(seatNo, flightId);
		
		if(seatOp.isPresent()) {
			Seat seat = seatOp.get();
			if(seat.getStatus().equals("unbooked")) {
				throw new SeatNotFoundException("Seat no: "+seatNo +" is not available to cancel as its not booked");
			}
			seat.setStatus("unbooked");
			return seatRepository.save(seat);
		} else {
			// throw exception
			throw new SeatNotFoundException("Seat no: "+seatNo +" not available to cancel");
		}
	}

}
