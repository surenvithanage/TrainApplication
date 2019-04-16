package com.ds.trainapplication.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ds.trainapplication.mapping.Customer;
import com.ds.trainapplication.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
@Api(value = "Customer Controller")
@CrossOrigin( value = "http://localhost:4200")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@ApiOperation(value = "Create Customer")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(method = RequestMethod.POST, value = "create")
	ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		return service.createCustomer(customer);
	}

	@ApiOperation(value = "Find Customer")
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	ResponseEntity<Customer> findCustomer(@PathVariable(value = "id") int customer_id) {
		return service.findCustomer(customer_id);
	}

	@ApiOperation(value = "View All Customers")
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Customer> listCustomer() {
		return service.listCustomer();
	}

	@ApiOperation(value = "Update Customer")
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") int customer_id,
			@Valid @RequestBody Customer customer) {
		return service.updateCustomer(customer_id, customer);
	}

	@ApiOperation(value = "Delete Customer")
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	Map<String, Boolean> deleteCustomer(@PathVariable("id") int id) {
		return service.deleteCustomer(id);
	}

}
