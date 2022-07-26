package com.airline.booking.model;

import java.util.List;

import com.airline.booking.entity.User;

public class BookingRequest {

	private String mealOpt;
	private List<Integer> seatNumbers;
	private Integer flightId;
	private User user;
	
	public BookingRequest() {
		super();
	}

	public BookingRequest( String mealOpt, List<Integer> seatNumbers, Integer flightId) {
		super();
		this.mealOpt = mealOpt;
		this.seatNumbers = seatNumbers;
		this.flightId = flightId;
	}

	public String getMealOpt() {
		return mealOpt;
	}

	public void setMealOpt(String mealOpt) {
		this.mealOpt = mealOpt;
	}

	public List<Integer> getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(List<Integer> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	
	
	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
