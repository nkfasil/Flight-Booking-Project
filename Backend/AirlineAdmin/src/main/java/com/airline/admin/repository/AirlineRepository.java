package com.airline.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.admin.entity.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {

}
