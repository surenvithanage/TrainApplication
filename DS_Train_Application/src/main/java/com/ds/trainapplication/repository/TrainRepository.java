package com.ds.trainapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ds.trainapplication.mapping.Train;


@Repository
public interface TrainRepository extends CrudRepository<Train, Integer>{

}
