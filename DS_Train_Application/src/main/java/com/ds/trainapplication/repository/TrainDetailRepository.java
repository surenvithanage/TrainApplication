package com.ds.trainapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ds.trainapplication.mapping.Traindetail;


@Repository
public interface TrainDetailRepository extends CrudRepository<Traindetail, Integer> {

}
