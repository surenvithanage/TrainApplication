package com.ds.trainapplication.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ds.trainapplication.mapping.Schedulestation;


public interface ScheduleStationService {
	ResponseEntity<Schedulestation> createSchedulestation(Schedulestation scheduleStation);

	ResponseEntity<Schedulestation> findSchedulestation(int schedulestation_id);

	Iterable<Schedulestation> listSchedulestation();

	ResponseEntity<Schedulestation> updateSchedulestation(int schedulestation_id, Schedulestation scheduleStation);

	Map<String, Boolean> deleteSchedulestation(int schedulestation_id);
}
