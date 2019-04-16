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

import com.ds.trainapplication.mapping.Station;
import com.ds.trainapplication.service.StationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/station")
@Api(value = "Station Controller")
@CrossOrigin(value = "http://localhost:4200")
public class StationController {
	
	@Autowired
	private StationService stationService;
	
	public StationController(StationService stationService) {
		this.stationService = stationService;
	}
	
	@ApiOperation(value = "Create Station")
	@RequestMapping(method = RequestMethod.POST, value = "create")
	ResponseEntity<Station> createSchedulestation( @Valid @RequestBody Station station) {
		return stationService.createSchedulestation(station);
	}

	@ApiOperation(value = "Find Station")
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	ResponseEntity<Station> findStation(@PathVariable(value = "id") int station_id) {
		return stationService.findStation(station_id);
	}

	@ApiOperation(value = "View All Stations")
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Station> listStation() {
		return stationService.listStation();
	}

	@ApiOperation(value = "Update Station")
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	ResponseEntity<Station> updateStation(@PathVariable(value = "id") int station_id, @Valid @RequestBody Station station) {
		return stationService.updateStation(station_id, station);
	}

	@ApiOperation(value = "Delete Station")
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	Map<String, Boolean> deleteStation(@PathVariable(value = "id") int station_id) {
		return stationService.deleteStation(station_id);
	}
}
