package com.ds.trainapplication.serviceimplementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ds.trainapplication.mapping.Traindetail;
import com.ds.trainapplication.repository.TrainDetailRepository;
import com.ds.trainapplication.service.TrainDetailService;
import com.ds.trainapplication.util.exception.ResourceNotFoundException;

@Service
public class TrainDetailServiceImplementation implements TrainDetailService {

	@Autowired
	private TrainDetailRepository repository;

	@Override
	public ResponseEntity<Traindetail> createTrainDetail(Traindetail traindetail) {
		try {
			repository.save(traindetail);
			return ResponseEntity.ok().body(traindetail);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Traindetail> findTrainDetail(int traindetail_id) {
		try {
			Traindetail traindetail = repository.findById(traindetail_id).orElseThrow(
					() -> new ResourceNotFoundException("Train detail with ID : " + traindetail_id + " not found."));
			return ResponseEntity.ok().body(traindetail);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Traindetail> listTrainDetail() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Traindetail> updateTrainDetail(int traindetail_id, Traindetail traindetail) {
		try {
			Traindetail traindetailinfo = repository.findById(traindetail_id).orElseThrow(
					() -> new ResourceNotFoundException("Train detail with ID : " + traindetail_id + " not found."));
			traindetailinfo.setId(traindetail.getId());
			traindetailinfo.setDestination(traindetail.getDestination());
			traindetailinfo.setFairFirstClass(traindetail.getFairFirstClass());
			traindetailinfo.setFairSecondClass(traindetail.getFairSecondClass());
			traindetailinfo.setFairThirdClass(traindetail.getFairThirdClass());
			traindetailinfo.setOrigin(traindetail.getOrigin());
			traindetailinfo.setTotalNoOfSeats(traindetail.getTotalNoOfSeats());
			final Traindetail traindetails = repository.save(traindetailinfo);
			return ResponseEntity.ok().body(traindetails);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Map<String, Boolean> deleteTrainDetail(int traindetail_id) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			Traindetail traindetail = repository.findById(traindetail_id).orElseThrow(
					() -> new ResourceNotFoundException("Train detail with ID : " + traindetail_id + " not found."));
			repository.delete(traindetail);
			map.put("Deleted Successfully", true);
		} catch (Exception ex) {
			map.put("Delete Unsuccessfull", false);
		}
		return map;
	}

}
