package com.ds.trainapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ds.trainapplication.mapping.Schedulestation;


@Repository
public interface ScheduleStationRepository extends CrudRepository<Schedulestation, Integer>{

}
