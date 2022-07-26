package com.airline.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.admin.entity.Seat;
import com.airline.admin.exception.SeatNotFoundException;
import com.airline.admin.service.SeatService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/flight/seat")
public class SeatController {

	@Autowired
	SeatService seatService;

	@PutMapping("/{flightId}")
	public ResponseEntity<Seat> updateSeatStatus(@PathVariable("flightId") Integer flightId, @RequestBody Seat seat) throws SeatNotFoundException {
		return new ResponseEntity<>(seatService.updateSeatStatus(seat.getSeatNo(), seat.getStatus(), flightId), HttpStatus.OK);
	}
	
	@PutMapping("/cancel/{flightId}")
	public ResponseEntity<Seat> cancelSeatStatus(@PathVariable("flightId") Integer flightId, @RequestBody Seat seat) throws SeatNotFoundException {
		return new ResponseEntity<>(seatService.cancelSeatStatus(seat.getSeatNo(), seat.getStatus(), flightId), HttpStatus.OK);
	}

}
