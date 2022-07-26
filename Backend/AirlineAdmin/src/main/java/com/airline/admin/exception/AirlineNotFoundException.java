package com.airline.admin.exception;

public class AirlineNotFoundException extends Exception {

	public AirlineNotFoundException() {}
	public AirlineNotFoundException(String s) {
		super(s);
	}
	public AirlineNotFoundException(Exception e) {
		super(e);
	}
	public AirlineNotFoundException(String s, Exception e) {
		super(s, e);
	}
}
