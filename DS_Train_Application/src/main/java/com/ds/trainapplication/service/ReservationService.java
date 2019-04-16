package com.ds.trainapplication.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ds.trainapplication.mapping.Reservation;


public interface ReservationService {
	ResponseEntity<Reservation> createReservation(Reservation reservation);

	ResponseEntity<Reservation> findReservation(int reservation_id);

	Iterable<Reservation> listReservation();

	ResponseEntity<Reservation> updateReservation(int reservation_id, Reservation reservation);

	Map<String, Boolean> deleteReservation(int reservation_id);
}
