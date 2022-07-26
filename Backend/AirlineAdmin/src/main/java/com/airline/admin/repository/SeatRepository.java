package com.airline.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.admin.entity.Seat;


public interface SeatRepository extends JpaRepository<Seat, Integer> {

	Optional<Seat> findAllBySeatNoAndFlightIdAndStatus(Integer seatNo, Integer flightId, String status);

	Optional<Seat> findAllBySeatNoAndFlightId(Integer seatNo, Integer flightId);
	

}
