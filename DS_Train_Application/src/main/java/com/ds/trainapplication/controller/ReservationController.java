package com.ds.trainapplication.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ds.trainapplication.mapping.Reservation;
import com.ds.trainapplication.service.ReservationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reservation")
@Api(value = "Reservation Controller")
@CrossOrigin(value = "http://localhost:4200")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@ApiOperation(value = "Create Reservation")
	@RequestMapping(method = RequestMethod.POST, value = "create")
	ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
		return reservationService.createReservation(reservation);
	}

	@ApiOperation(value = "Find Reservation")
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	ResponseEntity<Reservation> findReservation(@PathVariable(value = "id") int reservation_id) {
		return reservationService.findReservation(reservation_id);
	}

	@ApiOperation(value = "View All Reservations")
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Reservation> listReservation() { 
		return reservationService.listReservation();
	}

	@ApiOperation(value = "Update Reservation")
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") int reservation_id, @Valid @RequestBody Reservation reservation) {
		return reservationService.updateReservation(reservation_id, reservation);
	}

	@ApiOperation(value = "Delete Reservation")
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	Map<String, Boolean> deleteReservation(@PathVariable(value = "id") int reservation_id) {
		return reservationService.deleteReservation(reservation_id);
	}
}
