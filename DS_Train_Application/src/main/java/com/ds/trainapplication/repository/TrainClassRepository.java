package com.ds.trainapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ds.trainapplication.mapping.Trainclass;


@Repository
public interface TrainClassRepository extends CrudRepository<Trainclass, Integer>{

}
