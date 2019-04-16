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

import com.ds.trainapplication.mapping.Traindetail;
import com.ds.trainapplication.service.TrainDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/traindetail")
@Api(value = "Train Detail Controller")
@CrossOrigin(value = "http://localhost:4200")
public class TrainDetailController {

	private TrainDetailService trainDetailService;
	
	@Autowired
	public TrainDetailController(TrainDetailService trainDetailService) {
		this.trainDetailService = trainDetailService;
	}

	@ApiOperation(value = "Create Train Detail")
	@RequestMapping(method = RequestMethod.POST, value = "create")
	ResponseEntity<Traindetail> createTrainDetail(@Valid @RequestBody Traindetail traindetail) {
		return trainDetailService.createTrainDetail(traindetail);
	}

	@ApiOperation(value = "Find Train Detail")
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	ResponseEntity<Traindetail> findTrainDetail(@PathVariable(value = "id") int traindetail_id) {
		return trainDetailService.findTrainDetail(traindetail_id);
	}

	@ApiOperation(value = "View All Train Details")
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Traindetail> listTrainDetail() {
		return trainDetailService.listTrainDetail();
	}

	@ApiOperation(value = "Update Train Detail")
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	ResponseEntity<Traindetail> updateTrainDetail(@PathVariable(value = "id") int traindetail_id, @Valid @RequestBody Traindetail traindetail) {
		return trainDetailService.updateTrainDetail(traindetail_id, traindetail);
	}

	@ApiOperation(value = "Delete Train Detail")
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	Map<String, Boolean> deleteTrainDetail(@PathVariable(value = "id") int traindetail_id) {
		return trainDetailService.deleteTrainDetail(traindetail_id);
	}
}
