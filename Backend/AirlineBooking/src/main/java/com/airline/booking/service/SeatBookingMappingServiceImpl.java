package com.airline.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.booking.entity.SeatBookingMapping;
import com.airline.booking.repository.SeatBookingMappingRepository;

@Service
public class SeatBookingMappingServiceImpl implements SeatBookingMappingService {
	
	@Autowired
	SeatBookingMappingRepository seatBookingMappingRepository;

	@Override
	public SeatBookingMapping save(SeatBookingMapping seatMapping) {
		return seatBookingMappingRepository.save(seatMapping);
	
	}

	@Override
	public void deleteSeat(Integer id) {
		seatBookingMappingRepository.deleteById(id);
		
	}

	@Override
	public List<SeatBookingMapping> getBookedList(Integer bookingId) {
		List<SeatBookingMapping> bookedSeatList = seatBookingMappingRepository.findByBookingId(bookingId);
		return bookedSeatList;
	}

}
