package com.airline.admin.model;

public class SearchCriteria {

	private String startDate;
	private String startTime;
	private String fromPlace;
	private String toPlace;
	
	public SearchCriteria() {
		super();
	}

	public SearchCriteria(String startDate, String startTime, String fromPlace, String toPlace) {
		super();
		this.startDate = startDate;
		this.startTime = startTime;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	
	
	
	
}
