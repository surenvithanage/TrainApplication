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

import com.ds.trainapplication.mapping.Schedulestation;
import com.ds.trainapplication.service.ScheduleStationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/scheduleStation")
@Api(value = "Schedule Station Controller")
@CrossOrigin(value = "http://localhost:4200")
public class ScheduleStationController {
	
	@Autowired
	private ScheduleStationService scheduleStationService;
	
	
	public ScheduleStationController(ScheduleStationService scheduleStationService) {
		this.scheduleStationService = scheduleStationService;
	}
	
	@ApiOperation(value = "Create Schedule Station")
	@RequestMapping(method = RequestMethod.POST, value = "create")
	ResponseEntity<Schedulestation> createSchedulestation(@Valid @RequestBody Schedulestation scheduleStation) {
		return scheduleStationService.createSchedulestation(scheduleStation);
	}

	@ApiOperation(value = "Find Schedule Station")
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	ResponseEntity<Schedulestation> findSchedulestation(@PathVariable(value = "id") int schedulestation_id) {
		return scheduleStationService.findSchedulestation(schedulestation_id);
	}

	@ApiOperation(value = "View All Schedule Station")
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Schedulestation> listSchedulestation() {
		return scheduleStationService.listSchedulestation();
	}

	@ApiOperation(value = "Update Schedule Station")
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	ResponseEntity<Schedulestation> updateSchedulestation(@PathVariable(value = "id") int schedulestation_id, @Valid @RequestBody Schedulestation scheduleStation) {
		return scheduleStationService.updateSchedulestation(schedulestation_id, scheduleStation);
	}

	@ApiOperation(value = "Delete Schedule Station")
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	Map<String, Boolean> deleteSchedulestation(@PathVariable(value = "id") int schedulestation_id) {
		return scheduleStationService.deleteSchedulestation(schedulestation_id);
	}

}
