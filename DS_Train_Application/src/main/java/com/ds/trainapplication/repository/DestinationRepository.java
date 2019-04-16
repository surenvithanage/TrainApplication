package com.ds.trainapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ds.trainapplication.mapping.Destination;


@Repository
public interface DestinationRepository extends CrudRepository<Destination, Integer>{

}
