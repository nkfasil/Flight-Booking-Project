package com.airline.booking.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.airline.booking.entity.Booking;
import com.airline.booking.entity.SeatBookingMapping;
import com.airline.booking.entity.User;
import com.airline.booking.exception.BookingNotFoundException;
import com.airline.booking.model.BookingRequest;
import com.airline.booking.model.Seat;
import com.airline.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	SeatBookingMappingService seatBookingMappingService;

	@Autowired
	UserService userSerivce;

	@Override
	public Booking bookFlight(BookingRequest bookingRequest) throws Exception {

		Booking newBooking = new Booking();
		
		Integer flightId = bookingRequest.getFlightId();

		newBooking.setBookingDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		newBooking.setBookingTime(new SimpleDateFormat("hh:mm:ss").format(new Date()));
		newBooking.setMealOpted(bookingRequest.getMealOpt());
		newBooking.setPnr(UUID.randomUUID().toString());
		newBooking.setStatus("booked");
		newBooking.setNumberOfSeats(bookingRequest.getSeatNumbers().size());

		User user = userSerivce.saveUser(bookingRequest.getUser());
		newBooking.setUser(user);

		HttpHeaders headers = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();

		List<Seat> seatList = new ArrayList<>();

		for (Integer seatNumber : bookingRequest.getSeatNumbers()) {
			Seat seat = new Seat();
			seat.setSeatNo(seatNumber);
			seat.setStatus("booked");

			HttpEntity e = new HttpEntity(seat, headers);

			ResponseEntity<Seat> responseSeat = restTemplate
					.exchange("http://localhost:8081/api/v1.0/flight/seat/" + flightId, HttpMethod.PUT, e, Seat.class);
			if (responseSeat.getBody().getId() == null)
				throw new BookingNotFoundException("Seats either not present or is already booked");
			seatList.add(responseSeat.getBody());

		}

		Booking book = bookingRepository.save(newBooking);

		List<SeatBookingMapping> list = new ArrayList<>();

		// use rest temp for seat service
		for (Integer seatNumber : bookingRequest.getSeatNumbers()) {
			SeatBookingMapping seatMapping = new SeatBookingMapping();
			seatMapping.setBooking(book);
			seatMapping.setFlightId(flightId);
			seatMapping.setSeatNo(seatNumber);
			list.add(seatBookingMappingService.save(seatMapping));
			// save to seatBookingMapping table as well.
		}
		book.setSeatBookingMappingList(list);
		book.setUser(user);

		return book;

	}

	@Override
	public List<Booking> bookingHistory(String emailId) throws BookingNotFoundException {
		User user = userSerivce.findByEmailId(emailId);
		List<Booking> bookingList = bookingRepository.findByUserId(user.getId());
		
		if (bookingList == null || bookingList.isEmpty())
			throw new BookingNotFoundException("No booking found for email id: " + emailId);
		
		else {
			
			for(Booking booking: bookingList) {
				Integer bookingId = booking.getId();
				List<SeatBookingMapping> seatsBookedList = seatBookingMappingService.getBookedList(bookingId);
				booking.setSeatBookingMappingList(seatsBookedList);
			}
			
			return bookingList;
			
		}
			
	}

	@Override
	@Transactional
	public String cancelBooking(String pnr) throws BookingNotFoundException {

		Booking book = getBookedTicket(pnr);

		List<Seat> seats = new ArrayList<>();
		HttpHeaders headers = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		
		for (SeatBookingMapping seatMapping : book.getSeatBookingMappingList()) {
			Seat seat = new Seat();
			seat.setSeatNo(seatMapping.getSeatNo());
			seat.setStatus("unbooked");

			HttpEntity e = new HttpEntity(seat, headers);

			ResponseEntity<Seat> responseSeat = restTemplate
					.exchange("http://localhost:8081/api/v1.0/flight/seat/cancel/" + seatMapping.getFlightId(), HttpMethod.PUT, e, Seat.class);
			if (responseSeat.getBody().getId() == null)
				throw new BookingNotFoundException("Seats not present");
			
			seatBookingMappingService.deleteSeat(seatMapping.getId());
		}
		long deletedTicketNumber = bookingRepository.deleteByPnr(pnr);

		return deletedTicketNumber + " booking cancelled";
	}

	@Override
	public Booking getBookedTicket(String pnr) throws BookingNotFoundException {

		// need to add seat_booking_mapping list too, its coming null now
		Booking bookedTicket = bookingRepository.findByPnr(pnr);

		if (bookedTicket == null) {
			throw new BookingNotFoundException("Booking with pnr: " + pnr + " not available");
		
		} else {

			List<SeatBookingMapping> seatsBookedList = seatBookingMappingService.getBookedList(bookedTicket.getId());
			bookedTicket.setSeatBookingMappingList(seatsBookedList);

			return bookedTicket;
		}
	}

	@Override
	public List<Booking> getBookings() {
		return bookingRepository.findAll();
	}

}
