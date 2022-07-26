package com.airline.booking.exception;

public class BookingNotFoundException extends Exception {

	public BookingNotFoundException() {}
	public BookingNotFoundException(String s) {
		super(s);
	}
	public BookingNotFoundException(Exception e) {
		super(e);
	}
	public BookingNotFoundException(String s, Exception e) {
		super(s, e);
	}
}
