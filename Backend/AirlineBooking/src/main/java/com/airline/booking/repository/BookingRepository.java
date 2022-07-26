package com.airline.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	////wont work as email id not present in booking entity, so simply written meal opted
	List<Booking> findAllByMealOpted(String emailId);

	Booking findByPnr(String pnr);

	long deleteByPnr(String pnr);

	List<Booking> findByUserId(Integer userId);

}
