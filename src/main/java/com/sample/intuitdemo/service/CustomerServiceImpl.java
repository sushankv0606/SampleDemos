package com.sample.intuitdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.intuitdemo.dao.CustomerRepository;
import com.sample.intuitdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository theCustomerRespository) {
		customerRepository = theCustomerRespository;
	}
	
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int theId) {
		Optional<Customer> result = customerRepository.findById(theId);
		Customer theCustomer = null;
		if(result.isPresent()) {
			theCustomer=result.get();
		}else {
			throw new RuntimeException("Couldnt Find the Customer with ID: "+theId);
		}
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		customerRepository.deleteById(theId);
	}

	@Override
	public List<Customer> findByType(String type) {
		// TODO Auto-generated method stub
		List<Customer> typeCustomers=customerRepository.findByType(type);
		return typeCustomers;
	}

}






