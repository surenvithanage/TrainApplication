package com.ds.trainapplication.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ds.trainapplication.mapping.Destination;


public interface DestinationService {

	ResponseEntity<Destination> createDestination(Destination destination);

	ResponseEntity<Destination> findDestination(int destination_id);

	Iterable<Destination> listDestination();

	ResponseEntity<Destination> updateDestination(int destination_id, Destination destination);

	Map<String, Boolean> deleteDestination(int destination_id);
}
