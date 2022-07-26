package com.airline.booking.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String gender;
	private Integer age;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Booking> bookingList;
	
	public User() {
		super();
	}
	

	public User(Integer id) {
		super();
		this.id = id;
	}


	public User(Integer id, String name, String email, String gender, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	public List<Booking> getBookingList() {
		return bookingList;
	}


	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	
	
	
	
}
