package com.airline.admin.service;

import org.springframework.stereotype.Service;

import com.airline.admin.entity.Seat;
import com.airline.admin.exception.SeatNotFoundException;


@Service
public interface SeatService {

	Seat updateSeatStatus(Integer seatId, String status, Integer flightId) throws SeatNotFoundException;

	Seat cancelSeatStatus(Integer seatNo, String status, Integer flightId) throws SeatNotFoundException;
}
