package com.sample.intuitdemo.service;

import java.util.List;

import com.sample.intuitdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public List<Customer> findByType(String type);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
	
}
