package com.airline.admin.exception;

import java.time.LocalDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionFlightHandler {

	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleEx(FlightNotFoundException e){
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(
						e.getMessage(), 
						LocalDateTime.now(), 
						e.getClass().toString())
				, HttpStatus.OK);
	}
	
	@ExceptionHandler(SeatNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleEx(SeatNotFoundException e){
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(
						e.getMessage(), 
						LocalDateTime.now(), 
						e.getClass().toString())
				, HttpStatus.OK);
	}
	
	@ExceptionHandler(AirlineNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleEx(AirlineNotFoundException e){
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(
						e.getMessage(), 
						LocalDateTime.now(), 
						e.getClass().toString())
				, HttpStatus.OK);
	}
	
}
