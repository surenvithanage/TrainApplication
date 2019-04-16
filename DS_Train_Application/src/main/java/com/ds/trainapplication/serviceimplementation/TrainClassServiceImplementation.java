package com.ds.trainapplication.serviceimplementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ds.trainapplication.mapping.Trainclass;
import com.ds.trainapplication.repository.TrainClassRepository;
import com.ds.trainapplication.service.TrainClassService;
import com.ds.trainapplication.util.exception.ResourceNotFoundException;

@Service
public class TrainClassServiceImplementation implements TrainClassService {

	@Autowired
	private TrainClassRepository repository;

	@Override
	public ResponseEntity<Trainclass> createTrainclass(Trainclass trainclass) {
		try {
			repository.save(trainclass);
			return ResponseEntity.ok().body(trainclass);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Trainclass> findTrainclass(int trainclass_id) {
		try {
			Trainclass trainclass = repository.findById(trainclass_id).orElseThrow(
					() -> new ResourceNotFoundException("Train class with ID : " + trainclass_id + " not found."));
			return ResponseEntity.ok().body(trainclass);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Trainclass> listTrainclass() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Trainclass> updateTrainclass(int trainclass_id, Trainclass trainclass) {
		try {
			Trainclass trainclassinfo = repository.findById(trainclass_id).orElseThrow(
					() -> new ResourceNotFoundException("Train Class_id with ID : " + trainclass_id + " not found."));
			trainclassinfo.setId(trainclass.getId());
			trainclassinfo.setName(trainclass.getName());
			final Trainclass trainclassdetails = repository.save(trainclassinfo);
			return ResponseEntity.ok().body(trainclassdetails);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Map<String, Boolean> deleteTrainclass(int trainclass_id) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			Trainclass trainclass = repository.findById(trainclass_id).orElseThrow(
					() -> new ResourceNotFoundException("Train class with ID : " + trainclass_id + " not found."));
			repository.delete(trainclass);
			map.put("Deleted Successfully", true);
		} catch (Exception ex) {
			map.put("Delete Unsuccessfull", false);
		}
		return map;
	}

}
