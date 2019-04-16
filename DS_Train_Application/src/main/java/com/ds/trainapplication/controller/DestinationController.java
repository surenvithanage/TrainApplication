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

import com.ds.trainapplication.mapping.Destination;
import com.ds.trainapplication.service.DestinationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/destination")
@Api(value = "Destination Controller")
@CrossOrigin(value = "http://localhost:4200")
public class DestinationController {

	private DestinationService destinationService;
	
	@Autowired
	public DestinationController(DestinationService destinationService) {
		this.destinationService = destinationService;
	}
	
	@ApiOperation(value = "Create Destination")
	@RequestMapping(method = RequestMethod.POST, value = "create")
	ResponseEntity<Destination> createDestination(@Valid @RequestBody Destination destination) {
		return destinationService.createDestination(destination);
	}

	@ApiOperation(value = "Find Destination")
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	ResponseEntity<Destination> findDestination(@PathVariable(value = "id") int destination_id) {
		return destinationService.findDestination(destination_id);
	}

	@ApiOperation(value = "View All Destinations")
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Destination> listDestination() {
		return destinationService.listDestination();
	}

	@ApiOperation(value = "Update Destination")
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	ResponseEntity<Destination> updateDestination(@PathVariable(value = "id") int destination_id, @Valid @RequestBody Destination destination) {
		return destinationService.updateDestination(destination_id, destination);
	}

	@ApiOperation(value = "Delete Destination")
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	Map<String, Boolean> deleteDestination(@PathVariable(value = "id") int destination_id) {
		return destinationService.deleteDestination(destination_id);
	}
}
