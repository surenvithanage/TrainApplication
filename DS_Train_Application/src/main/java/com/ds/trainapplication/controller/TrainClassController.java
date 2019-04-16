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

import com.ds.trainapplication.mapping.Trainclass;
import com.ds.trainapplication.service.TrainClassService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/trainclass")
@Api(value = "Train Class Controller")
@CrossOrigin(value = "http://localhost:4200")
public class TrainClassController {

	private TrainClassService trainclassService;

	@Autowired
	public TrainClassController(TrainClassService trainclassService) {
		this.trainclassService = trainclassService;
	}
	
	@ApiOperation(value = "Create Train Class")
	@RequestMapping(method = RequestMethod.POST, value = "create")
	ResponseEntity<Trainclass> createTrainclass( @Valid @RequestBody Trainclass trainclass) {
		return trainclassService.createTrainclass(trainclass);
	}

	@ApiOperation(value = "Find Train Class")
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	ResponseEntity<Trainclass> findTrainclass(@PathVariable(value = "id") int trainclass_id) {
		return trainclassService.findTrainclass(trainclass_id);
	}

	@ApiOperation(value = "View All Train Class")
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Trainclass> listTrainclass() {
		return trainclassService.listTrainclass();
	}

	@ApiOperation(value = "Update Train Class")
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	ResponseEntity<Trainclass> updateTrainclass(@PathVariable(value = "id") int trainclass_id, @Valid @RequestBody Trainclass trainclass) {
		return trainclassService.updateTrainclass(trainclass_id, trainclass);
	}

	@ApiOperation(value = "Delete Train Class")
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	Map<String, Boolean> deleteTrainclass(@PathVariable(value = "id") int trainclass_id) {
		return trainclassService.deleteTrainclass(trainclass_id);
	}
}
