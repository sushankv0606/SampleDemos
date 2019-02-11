package com.sample.intuitdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.intuitdemo.entity.Customer;
import com.sample.intuitdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerRestController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	// expose "/customers" and return list of customers
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	// add mapping for GET /customers/{customerId}
	
	@GetMapping("/customer/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.findById(customerId);
		
		if (theCustomer == null) {
			throw new RuntimeException("Customer id not found - " + customerId);
		}
		
		return theCustomer;
	}
	
	// add mapping for GET /customers/{type}
	
		@GetMapping("/customer/find/{type}")
		public List<Customer> getCustomer(@PathVariable("type") String type) {
			
			List<Customer> theCustomer = customerService.findByType(type);
			
			if (theCustomer == null) {
				throw new RuntimeException("Customer type not found - " + type);
			}
			
			return theCustomer;
		}
	
	// add mapping for POST /customers - add new customer
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theCustomer.setId(0);
		
		customerService.save(theCustomer);
		
		return theCustomer;
	}
	
	// add mapping for PUT /customers - update existing customer
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.save(theCustomer);
		
		return theCustomer;
	}
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.findById(customerId);
		
		// throw exception if null
		
		if (tempCustomer == null) {
			throw new RuntimeException("Customer id not found - " + customerId);
		}
		
		customerService.deleteById(customerId);
		
		return "Deleted customer id - " + customerId;
	}
	
}










