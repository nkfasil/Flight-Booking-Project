package com.airline.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.booking.entity.SeatBookingMapping;

public interface SeatBookingMappingRepository extends JpaRepository<SeatBookingMapping, Integer> {

	List<SeatBookingMapping> findByBookingId(Integer bookingId);


}
