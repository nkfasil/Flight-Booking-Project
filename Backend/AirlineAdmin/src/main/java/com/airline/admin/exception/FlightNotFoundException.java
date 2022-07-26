package com.airline.admin.exception;

public class FlightNotFoundException extends Exception {

	public FlightNotFoundException() {}
	public FlightNotFoundException(String s) {
		super(s);
	}
	public FlightNotFoundException(Exception e) {
		super(e);
	}
	public FlightNotFoundException(String s, Exception e) {
		super(s, e);
	}
}
