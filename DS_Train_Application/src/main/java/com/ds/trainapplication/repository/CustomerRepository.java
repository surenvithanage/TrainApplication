package com.ds.trainapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ds.trainapplication.mapping.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

}
