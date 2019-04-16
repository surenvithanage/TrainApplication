package com.ds.trainapplication.serviceimplementation;

import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ds.trainapplication.mapping.Customer;
import com.ds.trainapplication.repository.CustomerRepository;
import com.ds.trainapplication.service.CustomerService;
import com.ds.trainapplication.util.exception.ResourceNotFoundException;
import com.ds.trainapplication.util.messagelist.MessageList;


@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	private static final Logger logger = Logger.getLogger(CustomerServiceImplementation.class);

	@Override
	public ResponseEntity<Customer> createCustomer(Customer customer) {
		try {
			logger.info(MessageList.CREATE_CUSTOMER);
			repository.save(customer);
			return ResponseEntity.ok().body(customer);
		} catch (Exception e) {
			logger.error(MessageList.ERROR_CREATE_CUSTOMER + " : " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Customer> findCustomer(int customer_id) {
		try {
			logger.info(MessageList.FIND_CUSTOMER);
			Customer customer = repository.findById(customer_id).orElseThrow(
					() -> new ResourceNotFoundException("Customer with ID : " + customer_id + " not found."));
			return ResponseEntity.ok().body(customer);
		} catch (ResourceNotFoundException e) {
			logger.error(MessageList.ERROR_FIND_CUSTOMER + " : " + e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Customer> listCustomer() {
		logger.info(MessageList.VIEW_CUSTOMER);
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(int customer_id, Customer customer) {
		try {
			logger.info(MessageList.UPDATE_CUSTOMER);
			Customer customerinfo = repository.findById(customer_id).orElseThrow(
					() -> new ResourceNotFoundException("Customer with ID : " + customer_id + " not found."));
			customerinfo.setFirstName(customer.getFirstName());
			customerinfo.setLastName(customer.getLastName());
			customerinfo.setAddress(customer.getAddress());
			customerinfo.setAge(customer.getAge());
			customerinfo.setEmail(customer.getEmail());
			customerinfo.setPhonenumber(customer.getPhonenumber());
			final Customer customerdetails = repository.save(customerinfo);
			return ResponseEntity.ok().body(customerdetails);
		} catch (ResourceNotFoundException e) {
			logger.error(MessageList.ERROR_UPDATE_CUSTOMER + " : " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Map<String, Boolean> deleteCustomer(int id) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			logger.info(MessageList.DELETE_CUSTOMER);
			Customer customer = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer with ID : " + id + " not found."));
			repository.delete(customer);
			map.put("Deleted Successfully", true);
		} catch (Exception ex) {
			logger.error(MessageList.ERROR_DELETE_CUSTOMER + " : " + ex);
			map.put("Delete Unsuccessfull", false);
		}
		return map;

	}

}
