package com.airline.booking.service;

import java.util.List;

import com.airline.booking.entity.SeatBookingMapping;

public interface SeatBookingMappingService {

	SeatBookingMapping save(SeatBookingMapping seatMapping);

	void deleteSeat(Integer id);
	
	List<SeatBookingMapping> getBookedList(Integer bookingId); 

}
