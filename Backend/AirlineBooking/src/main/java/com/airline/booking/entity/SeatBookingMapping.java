package com.airline.booking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="seat_booking_mapping")
public class SeatBookingMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JsonBackReference
	private Booking booking;
	private Integer seatNo;
	private Integer flightId;
	
	public SeatBookingMapping() {
		super();
	}

	public SeatBookingMapping(Integer id, Booking booking, Integer seatNo, Integer flightId) {
		super();
		this.id = id;
		this.booking = booking;
		this.seatNo = seatNo;
		this.flightId = flightId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	
	

	
}
