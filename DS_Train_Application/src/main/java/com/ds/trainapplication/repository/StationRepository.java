package com.ds.trainapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ds.trainapplication.mapping.Station;


@Repository
public interface StationRepository extends CrudRepository<Station, Integer>{

}
