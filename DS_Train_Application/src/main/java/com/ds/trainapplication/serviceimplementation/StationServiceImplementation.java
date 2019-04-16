package com.ds.trainapplication.serviceimplementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ds.trainapplication.mapping.Station;
import com.ds.trainapplication.repository.StationRepository;
import com.ds.trainapplication.service.StationService;
import com.ds.trainapplication.util.exception.ResourceNotFoundException;

@Service
public class StationServiceImplementation implements StationService {

	@Autowired
	private StationRepository repository;

	@Override
	public ResponseEntity<Station> createSchedulestation(Station station) {
		try {
			repository.save(station);
			return ResponseEntity.ok().body(station);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Station> findStation(int station_id) {
		try {
			Station station = repository.findById(station_id).orElseThrow(
					() -> new ResourceNotFoundException("Station with ID : " + station_id + " not found."));
			return ResponseEntity.ok().body(station);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Station> listStation() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Station> updateStation(int station_id, Station station) {
		try {
			Station stationinfo = repository.findById(station_id).orElseThrow(
					() -> new ResourceNotFoundException("Station with ID : " + station_id + " not found."));
			stationinfo.setId(station.getId());
			stationinfo.setName(station.getName());
			final Station stationdetails = repository.save(stationinfo);
			return ResponseEntity.ok().body(stationdetails);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Map<String, Boolean> deleteStation(int station_id) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			Station station = repository.findById(station_id).orElseThrow(
					() -> new ResourceNotFoundException("Station with ID : " + station_id + " not found."));
			repository.delete(station);
			map.put("Deleted Successfully", true);
		} catch (Exception ex) {
			map.put("Delete Unsuccessfull", false);
		}
		return map;
	}

}
