package com.ds.trainapplication.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ds.trainapplication.mapping.Trainclass;


public interface TrainClassService {
	ResponseEntity<Trainclass> createTrainclass(Trainclass trainclass);

	ResponseEntity<Trainclass> findTrainclass(int trainclass_id);

	Iterable<Trainclass> listTrainclass();

	ResponseEntity<Trainclass> updateTrainclass(int trainclass_id, Trainclass trainclass);

	Map<String, Boolean> deleteTrainclass(int trainclass_id);
}
