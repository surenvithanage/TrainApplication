package com.ds.trainapplication.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ds.trainapplication.mapping.Station;


public interface StationService {
	ResponseEntity<Station> createSchedulestation(Station station);

	ResponseEntity<Station> findStation(int station_id);

	Iterable<Station> listStation();

	ResponseEntity<Station> updateStation(int station_id, Station station);

	Map<String, Boolean> deleteStation(int station_id);
}
