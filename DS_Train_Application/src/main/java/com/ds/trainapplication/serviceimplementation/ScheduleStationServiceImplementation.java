package com.ds.trainapplication.serviceimplementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ds.trainapplication.mapping.Schedulestation;
import com.ds.trainapplication.repository.ScheduleStationRepository;
import com.ds.trainapplication.service.ScheduleStationService;
import com.ds.trainapplication.util.exception.ResourceNotFoundException;

@Service
public class ScheduleStationServiceImplementation implements ScheduleStationService{
	
	@Autowired
	private ScheduleStationRepository repository;
	
	@Override
	public ResponseEntity<Schedulestation> createSchedulestation(Schedulestation scheduleStation) {
		try {
			repository.save(scheduleStation);
			return ResponseEntity.ok().body(scheduleStation);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Schedulestation> findSchedulestation(int schedulestation_id) {
		try {
			Schedulestation scheduleStation = repository.findById(schedulestation_id).orElseThrow(
					() -> new ResourceNotFoundException("Schedule station with ID : " + schedulestation_id + " not found."));
			return ResponseEntity.ok().body(scheduleStation);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Schedulestation> listSchedulestation() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Schedulestation> updateSchedulestation(int schedulestation_id,
			Schedulestation scheduleStation) {
		try {
			Schedulestation scheduleStationinfo = repository.findById(schedulestation_id).orElseThrow(
					() -> new ResourceNotFoundException("Schedule station with ID : " + schedulestation_id + " not found."));
			scheduleStationinfo.setId(scheduleStation.getId());
			scheduleStationinfo.setArrivalTime(scheduleStation.getArrivalTime());
			scheduleStationinfo.setDepartureTime(scheduleStation.getDepartureTime());
			scheduleStationinfo.setStation(scheduleStation.getStation());
			final Schedulestation schedulestationdetails = repository.save(scheduleStationinfo);
			return ResponseEntity.ok().body(schedulestationdetails);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Map<String, Boolean> deleteSchedulestation(int schedulestation_id) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			Schedulestation schedulestation = repository.findById(schedulestation_id)
					.orElseThrow(() -> new ResourceNotFoundException("Schedule station with ID : " + schedulestation_id + " not found."));
			repository.delete(schedulestation);
			map.put("Deleted Successfully", true);
		} catch (Exception ex) {
			map.put("Delete Unsuccessfull", false);
		}
		return map;
	}

}
