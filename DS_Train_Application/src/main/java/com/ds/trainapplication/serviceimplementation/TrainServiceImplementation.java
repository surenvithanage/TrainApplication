package com.ds.trainapplication.serviceimplementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ds.trainapplication.mapping.Train;
import com.ds.trainapplication.repository.TrainRepository;
import com.ds.trainapplication.service.TrainService;
import com.ds.trainapplication.util.exception.ResourceNotFoundException;

@Service
public class TrainServiceImplementation implements TrainService{

	@Autowired
	private TrainRepository repository;
	
	@Override
	public ResponseEntity<Train> createTrain(Train train) {
		try {
			repository.save(train);
			return ResponseEntity.ok().body(train);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Train> findTrain(int train_id) {
		try {
			Train train = repository.findById(train_id).orElseThrow(
					() -> new ResourceNotFoundException("Train with ID : " + train_id + " not found."));
			return ResponseEntity.ok().body(train);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Train> listTrain() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Train> updateTrain(int train_id, Train train) {
		try {
			Train traininfo = repository.findById(train_id).orElseThrow(
					() -> new ResourceNotFoundException("Train with ID : " + train_id + " not found."));
			traininfo.setId(train.getId());
			traininfo.setTrainName(train.getTrainName());
			traininfo.setTrainNumber(train.getTrainNumber());
			final Train traindetails = repository.save(traininfo);
			return ResponseEntity.ok().body(traindetails);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Map<String, Boolean> deleteTrain(int train_id) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			Train train = repository.findById(train_id)
					.orElseThrow(() -> new ResourceNotFoundException("Train with ID : " + train_id + " not found."));
			repository.delete(train);
			map.put("Deleted Successfully", true);
		} catch (Exception ex) {
			map.put("Delete Unsuccessfull", false);
		}
		return map;
	}

}
