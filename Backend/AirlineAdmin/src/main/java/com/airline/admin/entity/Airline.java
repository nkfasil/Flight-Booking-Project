package com.airline.admin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airline")
public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String status;
	
//	@OneToMany(mappedBy = "airline", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
//	private List<Flight> flight;
	
	public Airline() {
		super();
	}

	public Airline(Integer id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
//	public List<Flight> getFlight() {
//		return flight;
//	}
//
//	public void setFlight(List<Flight> flight) {
//		this.flight = flight;
//	}

	@Override
	public String toString() {
		return "Airline [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
	
	
	
}
