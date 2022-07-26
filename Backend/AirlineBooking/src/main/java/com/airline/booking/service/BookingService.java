package com.airline.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airline.booking.entity.Booking;
import com.airline.booking.exception.BookingNotFoundException;
import com.airline.booking.model.BookingRequest;

@Service
public interface BookingService {

	public Booking bookFlight(BookingRequest bookingRequest) throws Exception;
	
	public List<Booking> bookingHistory(String emailId) throws BookingNotFoundException;
	
	public String cancelBooking(String pnr) throws BookingNotFoundException;
	
	public Booking getBookedTicket(String pnr) throws BookingNotFoundException;

	public List<Booking> getBookings();
}
