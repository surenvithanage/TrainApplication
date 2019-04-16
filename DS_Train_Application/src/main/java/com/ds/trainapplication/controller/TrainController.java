package com.ds.trainapplication.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ds.trainapplication.mapping.Train;
import com.ds.trainapplication.service.TrainService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/train")
@Api(value = "Train Controller")
@CrossOrigin(value = "http://localhost:4200")
public class TrainController {
	
	private TrainService trainService;
	
	@Autowired
	public TrainController(TrainService trainService) {
		this.trainService = trainService;
	}
	
	@ApiOperation(value = "Create Train")
	@RequestMapping(method = RequestMethod.POST, value = "create")
	ResponseEntity<Train> createTrain(@Valid @RequestBody Train train) {
		return trainService.createTrain(train);
	}

	@ApiOperation(value = "Find Train")
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	ResponseEntity<Train> findTrain(@PathVariable(value = "id") int train_id) {
		return trainService.findTrain(train_id);
	}

	@ApiOperation(value = "View All Trains")
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Train> listTrain() {
		return trainService.listTrain();
	}

	@ApiOperation(value = "Update Train")
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	ResponseEntity<Train> updateTrain(@PathVariable(value = "id") int train_id, @Valid @RequestBody Train train) {
		return trainService.updateTrain(train_id, train);
	}

	@ApiOperation(value = "Delete Train")
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	Map<String, Boolean> deleteTrain(@PathVariable(value = "id") int train_id) {
		return trainService.deleteTrain(train_id);
	}
}
