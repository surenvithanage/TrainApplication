package com.ds.trainapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ds.trainapplication.mapping.Reservation;


@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer>{

}
