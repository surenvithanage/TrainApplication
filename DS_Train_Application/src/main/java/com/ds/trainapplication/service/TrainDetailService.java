package com.ds.trainapplication.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ds.trainapplication.mapping.Traindetail;


public interface TrainDetailService {
	ResponseEntity<Traindetail> createTrainDetail(Traindetail traindetail);

	ResponseEntity<Traindetail> findTrainDetail(int traindetail_id);

	Iterable<Traindetail> listTrainDetail();

	ResponseEntity<Traindetail> updateTrainDetail(int traindetail_id, Traindetail traindetail);

	Map<String, Boolean> deleteTrainDetail(int traindetail_id);
}
