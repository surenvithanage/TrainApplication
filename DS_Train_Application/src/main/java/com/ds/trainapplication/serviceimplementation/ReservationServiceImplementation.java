package com.ds.trainapplication.serviceimplementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ds.trainapplication.mapping.Reservation;
import com.ds.trainapplication.repository.ReservationRepository;
import com.ds.trainapplication.service.ReservationService;
import com.ds.trainapplication.util.exception.ResourceNotFoundException;


@Service
public class ReservationServiceImplementation implements ReservationService{

	@Autowired
	private ReservationRepository repository;
	
	@Override
	public ResponseEntity<Reservation> createReservation(Reservation reservation) {
		try {
			repository.save(reservation);
			return ResponseEntity.ok().body(reservation);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Reservation> findReservation(int reservation_id) {
		try {
			Reservation reservation = repository.findById(reservation_id).orElseThrow(
					() -> new ResourceNotFoundException("Reservation with ID : " + reservation_id + " not found."));
			return ResponseEntity.ok().body(reservation);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Reservation> listReservation() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Reservation> updateReservation(int reservation_id, Reservation reservation) {
		try {
			Reservation reservationinfo = repository.findById(reservation_id).orElseThrow(
					() -> new ResourceNotFoundException("Reservation with ID : " + reservation_id + " not found."));
			reservationinfo.setCustomer(reservation.getCustomer());
			reservationinfo.setDate(reservation.getDate());
			reservationinfo.setReceiptNumber(reservation.getReceiptNumber());
			reservationinfo.setSeatsReserved(reservation.getSeatsReserved());
			reservationinfo.setId(reservation.getId());
			final Reservation reservationdetails = repository.save(reservationinfo);
			return ResponseEntity.ok().body(reservationdetails);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Map<String, Boolean> deleteReservation(int reservation_id) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			Reservation reservation = repository.findById(reservation_id)
					.orElseThrow(() -> new ResourceNotFoundException("Reservation with ID : " + reservation_id + " not found."));
			repository.delete(reservation);
			map.put("Deleted Successfully", true);
		} catch (Exception ex) {
			map.put("Delete Unsuccessfull", false);
		}
		return map;
	}

}
