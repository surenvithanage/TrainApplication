package com.ds.trainapplication.serviceimplementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ds.trainapplication.mapping.Destination;
import com.ds.trainapplication.repository.DestinationRepository;
import com.ds.trainapplication.service.DestinationService;
import com.ds.trainapplication.util.exception.ResourceNotFoundException;

@Service
public class DestinationServiceImplementation implements DestinationService {

	@Autowired
	private DestinationRepository repository;

	@Override
	public ResponseEntity<Destination> createDestination(Destination destination) {
		try {
			repository.save(destination);
			return ResponseEntity.ok().body(destination);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Destination> findDestination(int destination_id) {
		try {
			Destination destination = repository.findById(destination_id).orElseThrow(
					() -> new ResourceNotFoundException("Destination with ID : " + destination_id + " not found."));
			return ResponseEntity.ok().body(destination);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Destination> listDestination() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Destination> updateDestination(int destination_id, Destination destination) {
		try {
			Destination destinationinfo = repository.findById(destination_id).orElseThrow(
					() -> new ResourceNotFoundException("Destination with ID : " + destination_id + " not found."));
			destinationinfo.setName(destinationinfo.getName());
			final Destination destinationdetails = repository.save(destinationinfo);
			return ResponseEntity.ok().body(destinationdetails);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Map<String, Boolean> deleteDestination(int destination_id) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			Destination destination = repository.findById(destination_id)
					.orElseThrow(() -> new ResourceNotFoundException("Destination with ID : " + destination_id + " not found."));
			repository.delete(destination);
			map.put("Deleted Successfully", true);
		} catch (Exception ex) {
			map.put("Delete Unsuccessfull", false);
		}
		return map;
	}

}
