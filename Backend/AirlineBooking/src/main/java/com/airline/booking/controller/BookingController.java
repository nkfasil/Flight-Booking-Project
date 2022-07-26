package com.airline.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.booking.entity.Booking;
import com.airline.booking.exception.BookingNotFoundException;
import com.airline.booking.model.BookingRequest;
import com.airline.booking.service.BookingService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/flight")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/booking")
	public ResponseEntity<Booking> bookTicket(@RequestBody BookingRequest bookingRequest) throws Exception {
		return new ResponseEntity<Booking>(bookingService.bookFlight(bookingRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("/ticket/{pnr}")
	public ResponseEntity<Booking> getBookedDetails(@PathVariable("pnr") String pnr) throws BookingNotFoundException{
		return new ResponseEntity<Booking>(bookingService.getBookedTicket(pnr), HttpStatus.OK);
	}
	
	@GetMapping("/booking/history/{emailId}")
	public ResponseEntity<List<Booking>> getBookingHistory(@PathVariable("emailId") String emailId) throws BookingNotFoundException {
		return new ResponseEntity<List<Booking>>(bookingService.bookingHistory(emailId),HttpStatus.OK);
	}
	
	@DeleteMapping("/booking/cancel/{pnr}")
	public ResponseEntity<String> cancelBooking(@PathVariable("pnr") String pnr) throws BookingNotFoundException {
		return new ResponseEntity<String>(bookingService.cancelBooking(pnr),HttpStatus.OK);
	}
	
	@GetMapping("/bookingsss")
	public List<Booking> getBookings(){
		return bookingService.getBookings();
	}

}
