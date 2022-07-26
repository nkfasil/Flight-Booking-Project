package com.airline.admin.exception;

public class SeatNotFoundException extends Exception {

	public SeatNotFoundException() {}
	public SeatNotFoundException(String s) {
		super(s);
	}
	public SeatNotFoundException(Exception e) {
		super(e);
	}
	public SeatNotFoundException(String s, Exception e) {
		super(s, e);
	}
}
