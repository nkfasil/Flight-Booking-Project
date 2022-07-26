package com.airline.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.admin.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
