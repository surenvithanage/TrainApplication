package com.ds.trainapplication.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ds.trainapplication.mapping.Customer;


public interface CustomerService {

	ResponseEntity<Customer> createCustomer(Customer customer);

	ResponseEntity<Customer> findCustomer(int customer_id);

	Iterable<Customer> listCustomer();

	ResponseEntity<Customer> updateCustomer(int customer_id, Customer customer);

	Map<String, Boolean> deleteCustomer(int id);

}
