package com.airline.booking.entity;

//import java.time.LocalDate;
//import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String bookingDate;
	private String bookingTime;
	private String mealOpted;
	private String pnr;
	private String status;
	private Integer numberOfSeats;
	
	@Transient
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	//@JoinColumn(name = "seat_id", updatable = false, insertable = false)
	private List<SeatBookingMapping> seatBookingMappingList; // Same with SeatBookingMapping

	@ManyToOne
	@JsonBackReference
	private User user;

	public Booking() {
		super();
	}

	public Booking(Integer id, String bookingDate, String bookingTime, String mealOpted, String pnr, String status,
			Integer numberOfSeats, List<SeatBookingMapping> seatBookingMappingList, User user) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.mealOpted = mealOpted;
		this.pnr = pnr;
		this.status = status;
		this.numberOfSeats = numberOfSeats;
		this.seatBookingMappingList = seatBookingMappingList;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getMealOpted() {
		return mealOpted;
	}

	public void setMealOpted(String mealOpted) {
		this.mealOpted = mealOpted;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public List<SeatBookingMapping> getSeatBookingMappingList() {
		return seatBookingMappingList;
	}

	public void setSeatBookingMappingList(List<SeatBookingMapping> seatBookingMappingList) {
		this.seatBookingMappingList = seatBookingMappingList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
