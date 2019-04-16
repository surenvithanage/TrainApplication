package com.ds.trainapplication.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ds.trainapplication.mapping.Train;


public interface TrainService {
	ResponseEntity<Train> createTrain(Train train);

	ResponseEntity<Train> findTrain(int train_id);

	Iterable<Train> listTrain();

	ResponseEntity<Train> updateTrain(int train_id, Train train);

	Map<String, Boolean> deleteTrain(int train_id);
}
