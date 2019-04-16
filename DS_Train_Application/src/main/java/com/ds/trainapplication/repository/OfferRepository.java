package com.ds.trainapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ds.trainapplication.mapping.Offer;


@Repository
public interface OfferRepository extends CrudRepository<Offer,Integer>{

}
